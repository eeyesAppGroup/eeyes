package com.eeyes.designtemplate.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.eeyes.designtemplate.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lizhaotailang on 2016/3/18.
 * 欢迎页
 */
public class SplashActivity extends AppCompatActivity {

    private ImageView ivWelcome;
    private TextView tvWelcomeName;

    private SharedPreferences sp;

    private final String TAG = "SplashActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getSharedPreferences("user_settings",MODE_PRIVATE);

        if (sp.getBoolean("load_splash",false)){

            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            } else {

                setContentView(R.layout.activity_splash);

                initViews();


                ivWelcome.setImageResource(R.drawable.welcome);
                tvWelcomeName.setText(R.string.welcome_to_zhihudaily);


                final Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                };
                timer.schedule(timerTask, 1000 * 3);
            }
        }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private void initViews() {

        ivWelcome = (ImageView) findViewById(R.id.iv_welcome);
        tvWelcomeName = (TextView) findViewById(R.id.tv_welcome_name);

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
