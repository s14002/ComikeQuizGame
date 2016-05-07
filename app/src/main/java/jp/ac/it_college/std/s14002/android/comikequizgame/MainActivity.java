package jp.ac.it_college.std.s14002.android.comikequizgame;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //タイトルバーを非表示にする（必ずsetContentViewの前にすること）
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // タイトルテキスト
        ((TextView)findViewById(R.id.titleText)).setTypeface(Typeface.createFromAsset(getAssets(), "manteka.ttf"));
        // Normalボタン
        ((Button)findViewById(R.id.button_normal)).setTypeface(Typeface.createFromAsset(getAssets(), "manteka.ttf"));
        // Randomボタン
        ((Button)findViewById(R.id.button_random)).setTypeface(Typeface.createFromAsset(getAssets(), "manteka.ttf"));
        // TimeAttackボタン
        ((Button)findViewById(R.id.button_time)).setTypeface(Typeface.createFromAsset(getAssets(), "manteka.ttf"));
    }

    // ボタンがタッチされた時の処理
    public void onClick(View v) {
        switch (v.getId()) {
            // タッチされたボタンがノーマルの場合
            case R.id.button_normal:
                // 遷移先のActivityを指定
                Intent intent = new Intent(MainActivity.this, StageSelect.class);
                startActivity(intent);
                break;
            // タッチされたボタンがランダムの場合
            case R.id.button_random:
                // 遷移先のActivityを指定
                intent = new Intent(MainActivity.this, SectionSelect.class);
                startActivity(intent);
                break;
            // タッチされたボタンがタイムアタックの場合
            case R.id.button_time:
                intent = new Intent(MainActivity.this, TimeAttackSelect.class);
                startActivity(intent);
                break;
        }
    }
}