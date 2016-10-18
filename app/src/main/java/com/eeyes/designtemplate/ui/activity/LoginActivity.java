package com.eeyes.designtemplate.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eeyes.designtemplate.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button loginButton;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.BLogin);
        registerTextView = (TextView) findViewById(R.id.tv_register);
        loginButton.setOnClickListener(this);
        registerTextView.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /**
             * 处理登陆逻辑，现在暂时留空，点击登录按钮直接跳转到MainActivity
             */
            case R.id.BLogin:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                //登陆完成后销毁登陆页面
                finish();
                break;
            /**
             * 处理注册逻辑，点击跳转到注册页面RegisterActivity
             */
            case R.id.tv_register:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                break;
            default:
                break;


        }

    }
}
