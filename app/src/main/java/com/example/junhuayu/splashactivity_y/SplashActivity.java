package com.example.junhuayu.splashactivity_y;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    private CountDownTimer mCountDownTimer;

    private TextView count_time_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        count_time_tv = findViewById(R.id.count_time_tv);
        count_time_tv.setOnClickListener(this);
        mCountDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {
                count_time_tv.setText(l/1000+"s 跳转");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        };
        mCountDownTimer.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mCountDownTimer != null){
            mCountDownTimer.cancel();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(SplashActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
