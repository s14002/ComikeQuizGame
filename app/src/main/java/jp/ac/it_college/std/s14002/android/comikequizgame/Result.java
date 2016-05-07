package jp.ac.it_college.std.s14002.android.comikequizgame;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Result extends AppCompatActivity implements GestureDetector.OnGestureListener  {
    GestureDetector gestureDetector;
    private String recordName;
    private String recordTime;
    private String clearName;
    private String clearTime;
    private PopupWindow mPopupWindow;
    private boolean best = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.gestureDetector = new GestureDetector(this, (GestureDetector.OnGestureListener) this);

        setContentView(R.layout.activity_result);
        startMeasure();


        loadData();
        clearTime = getIntent().getStringExtra("time");

        comparison();

        setText();

        final Button buttonOk = (Button)findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (best) {
                    popup();
                    buttonOk.setEnabled(false);
                } else {
                    finish();
                }
            }
        });
    }

    private void setText() {
        TextView rName = (TextView)findViewById(R.id.recordName);
        TextView rTime = (TextView)findViewById(R.id.recordTime);
        TextView cTime = (TextView)findViewById(R.id.clearTime);
        rName.setText(recordName);
        rTime.setText(recordTime);
        cTime.setText(clearTime);
    }

    private void saveData() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor e = pref.edit();
        e.putString("name", clearName);
        e.putString("time", clearTime);
        e.apply();
    }

    private void loadData() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        recordName = pref.getString("name", "noneName");
        recordTime = pref.getString("time", "noneTime");
    }

    private void comparison() {
        int record = splitTime(recordTime);
        int clear = splitTime(clearTime);
        if (record > clear) {
            //記録更新処理

            best = true;
        }
    }

    private int splitTime(String str) {
        Log.e("log :", str);
        if (!str.equals("noneTime")) {
            String[] times = str.split(":", 0);

            System.out.println(times[0]);
            System.out.println(times[1]);

            int sMinute = Integer.parseInt(times[0]) * 60;
            int second = Integer.parseInt(times[1]);

            int sum = sMinute + second;
            return sum;
        } else {
            return 1000;
        }
    }

    private void popup() {
        mPopupWindow = new PopupWindow(Result.this);

        // レイアウト設定
        final View popupView = getLayoutInflater().inflate(R.layout.popup_layout, null);
        popupView.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                    EditText text = (EditText)popupView.findViewById(R.id.input);
                    Log.e("Log",text.getText().toString());
                    clearName = text.getText().toString();
                    saveData();
                    best = false;

                    finish();
                }
            }
        });
        mPopupWindow.setContentView(popupView);

        /*// 背景設定
        mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_background));*/

        // タップ時に他のViewでキャッチされないための設定
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setTouchable(true);

        // 表示サイズの設定 今回は幅300dp
        float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
//        mPopupWindow.setWindowLayoutMode((int) width, WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setWidth((int) width);
        mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        // 画面中央に表示
//        mPopupWindow.showAtLocation(findViewById(R.id.show_button), Gravity.CENTER, 0, 0);
        mPopupWindow.showAtLocation(findViewById(R.id.buttonOk), Gravity.CENTER, 0, 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        if (best) popup();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    private Handler mHandler = new Handler();
    private ScheduledExecutorService mScheduledExecutor;
    private TextView mLblMeasuring;

    private void startMeasure() {


        /**
         * 点滅させたいView
         * TextViewじゃなくてもよい。
         */
//        mLblMeasuring = (TextView) findViewById(R.id.lbl_measuring);
        mLblMeasuring = (Button)findViewById(R.id.buttonOk);

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
}