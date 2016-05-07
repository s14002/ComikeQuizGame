package jp.ac.it_college.std.s14002.android.comikequizgame;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeAttackSelect extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private ScheduledExecutorService mScheduledExecutor;
    private TextView mLblMeasuring;

    @Override
    protected void onResume() {
        super.onResume();
        // ボタン処理呼び出し
//        setIcon();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_time_attack_select);
        startMeasure();

        findViewById(R.id.startButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeAttackSelect.this, TimeAttackGame.class);
                startActivity(intent);
            }
        });
    }

    private void startMeasure() {
        /**
         * 点滅させたいView
         * TextViewじゃなくてもよい。
         */
//        mLblMeasuring = (TextView) findViewById(R.id.lbl_measuring);
        mLblMeasuring = (Button) findViewById(R.id.startButton);

        /**
         * 第一引数: 繰り返し実行したい処理
         * 第二引数: 指定時間後に第一引数の処理を開始
         * 第三引数: 第一引数の処理完了後、指定時間後に再実行
         * 第四引数: 第二、第三引数の単位
         *
         * new Runnable（無名オブジェクト）をすぐに（0秒後に）実行し、完了後1700ミリ秒ごとに繰り返す。
         * （ただしアニメーションの完了からではない。Handler#postが即時実行だから？？）
         */
        mScheduledExecutor = Executors.newScheduledThreadPool(2);

        mScheduledExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLblMeasuring.setVisibility(View.VISIBLE);

                        // HONEYCOMBより前のAndroid SDKがProperty Animation非対応のため
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                            animateAlpha();
                        }
                    }
                });
            }


            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            private void animateAlpha() {

                // 実行するAnimatorのリスト
                List<Animator> animatorList = new ArrayList<>();

                // alpha値を0から1へ1000ミリ秒かけて変化させる。
                ObjectAnimator animeFadeIn = ObjectAnimator.ofFloat(mLblMeasuring, "alpha", 0f, 1f);
                animeFadeIn.setDuration(1000);

                // alpha値を1から0へ600ミリ秒かけて変化させる。
                ObjectAnimator animeFadeOut = ObjectAnimator.ofFloat(mLblMeasuring, "alpha", 1f, 0f);
                animeFadeOut.setDuration(600);

                // 実行対象Animatorリストに追加。
                animatorList.add(animeFadeIn);
                animatorList.add(animeFadeOut);

                final AnimatorSet animatorSet = new AnimatorSet();

                // リストの順番に実行
                animatorSet.playSequentially(animatorList);

                animatorSet.start();
            }
        }, 0, 1700, TimeUnit.MILLISECONDS);

    }

   /* // ボタンをクリア済みかどうかで色分け&クリック不可処理
    private void setIcon(){
        // 作成したDatabaseHelperクラスに読み込み専用でアクセス
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        String sql = "SELECT Clear FROM MyTable";
        //上記のSELECT文を実行してカーソルを取得
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        // CLEAR_FLAGを入れる配列(要素数はデータの数だけ)を作成
        int[] ClearFlg = new int[cursor.getCount()];
        // クリア状況取得して配列CLEAR_FLAGに入れていく
        for (int i = 0; i < cursor.getCount(); i++) {
            ClearFlg[i] = cursor.getInt(0);
            cursor.moveToNext();
        }
        // データベースからデータを撮り終わったのでクローズ処理
        cursor.close();
        database.close();
        for (int i = 1; i<= 6; i++) {
            // layoutでbuttonのidをbutton1~6で連番を振っているのでそれを利用する
            String resViewName = "button" + i;
            int viewId = getResources().getIdentifier(resViewName, "id", getPackageName());
            Button button = (Button)findViewById(viewId);
            // Clearの値によって処理を分ける
            if (i == 1) {
                button.setText("00:10");
            } else if (i == 2) {
                button.setText("01:00");
            } else if (i == 3) {
                button.setText("03:00");
            } else if (i == 4) {
                button.setText("05:00");
            } else if (i == 5){
                button.setText("07:00");
            } else {
                button.setText("10:00");
            }
            button.setTextColor(0xffff9900); //テキストの色
            button.setTextSize(50);
            button.setBackgroundColor(0xffffffff); // ボタンの色
        }
    }*/

    /*// ボタンクリックでゲーム画面へ遷移
    public void onClick(View v) {
        Intent intent = new Intent(TimeAttackSelect.this, TimeAttackGame.class);
        // 選択されたステージをボタンのテキストから取得
        intent.putExtra("Time", ((Button) v).getText());
        Log.e("Log", (String) ((Button) v).getText());
        startActivity(intent);
    }*/
}