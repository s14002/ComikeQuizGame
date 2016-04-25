package jp.ac.it_college.std.s14002.android.comikequizgame;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {
    final int SOUND_POOL_MAX = 2;
    String QuestionNo;
    String Seikai;
    // SoundPool(効果音再生)
    SoundPool soundPool;
    private int[] soundId = new int[SOUND_POOL_MAX]; //使う効果音の数だけ配列生成

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_game);

        // SoundPoolのインスタンス作成
        SoundPool.Builder builder = new SoundPool.Builder();
        soundPool = builder.build();

        //効果音をロードし、引数はContext、リソースID、優先度
        soundId[0] = soundPool.load(this, R.raw.se_maoudamashii_onepoint15, 1);
        soundId[1] = soundPool.load(this, R.raw.se_maoudamashii_onepoint33, 1);


        //ステージセレクトActivityから送られてきたデータを取得
        Intent intent = getIntent();
        QuestionNo = intent.getStringExtra("QuestionNo");
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onResume() {
        super.onResume();

        // 画面↑にあるテキストを「クイズNo.　+　問題No で表示
        ((TextView) findViewById(R.id.textNo)).setText("クイズNo." + QuestionNo);

        // 問題文セット処理呼び出し
        setQuestion();
    }

    // 問題文セット処理
    private void setQuestion() {
        // 作成したDatabaseHelperクラスに読み取り専用でアクセス
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

        String sql = "SELECT Pref, City0, City1, City2, City3, City4 FROM MyTable WHERE _id=" + QuestionNo;

        // SQL文を実行してカーソルを取得
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        // データベースから取ってきたデータを変数にセット
        String Kenmei = cursor.getString(cursor.getColumnIndex("Pref")); // 問題文
        String Choice1 = cursor.getString(cursor.getColumnIndex("City1")); // 四択の選択肢1
        String Choice2 = cursor.getString(cursor.getColumnIndex("City2")); // 四択の選択肢2
        String Choice3 = cursor.getString(cursor.getColumnIndex("City3")); // 四択の選択肢3
        String Choice4 = cursor.getString(cursor.getColumnIndex("City4")); // 四択の選択肢4

        Seikai = cursor.getString(cursor.getColumnIndex("City0")); // 答え

        // データベースのクローズ処理
        cursor.close();
        database.close();

        ((TextView) findViewById(R.id.textQuestion)).setText(Kenmei); // 問題文をテキストに表示
        ((Button) findViewById(R.id.button1)).setText(Choice1); // 四択の選択肢1をボタンに表示
        ((Button) findViewById(R.id.button2)).setText(Choice2); // 四択の選択肢2をボタンに表示
        ((Button) findViewById(R.id.button3)).setText(Choice3); // 四択の選択肢3をボタンに表示
        ((Button) findViewById(R.id.button4)).setText(Choice4); // 四択の選択肢4をボタンに表示

    }

    // onPauseが呼ばれたら効果音を関するものは全て開放する
    @Override
    protected void onPause() {
        super.onPause();
        // SoundPool 開放
        soundPool.unload(soundId[0]);
        soundPool.unload(soundId[1]);

        soundPool.release();
    }

    // 選択肢がクリックされた時の処理
    public void onClick(View v) {
        if (((Button) v).getText().equals(Seikai)) {
            // 正解の処理
            soundPool.play(soundId[0], 1.0f, 1.0f, 0, 0, 1.0f); // 正解音を再生

            // データベースを更新処理
            ContentValues values = new ContentValues();
            // Clear 0 → 1
            values.put("Clear", 1);
            // カラム選択
            String whereClause = "_id = ?";
            // データベースと接続
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            SQLiteDatabase database = databaseHelper.getWritableDatabase();
            // データベース更新
            int ret;
            try {
                ret = database.update("MyTable", values, whereClause, new String[]{String.valueOf((Integer.parseInt(QuestionNo) + 1))});
            } finally {
                database.close();
            }
            if (ret == -1) {
            } else {
            }

        } else {
            // 不正解の処理
            soundPool.play(soundId[1], 1.0f, 1.0f, 0, 0, 1.0f); //　不正解音を再生
        }
    }
}