package com.aiprous.medicobox.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.aiprous.medicobox.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import medicobox.aiprous.com.medicobox.R;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup)
    Button btn_signup;
    @BindView(R.id.tv_forgot_password)
    TextView tv_forgot_password;
    @BindView(R.id.tv_sign_up_here)
    TextView tv_sign_up_here;
    @BindView(R.id.btn_sign_in_withotp)
    Button btn_sign_in_withotp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_signup)
    public void onClickSignUp()
    {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    @OnClick(R.id.tv_forgot_password)
    public void onClickPassword()
    {
        startActivity(new Intent(this,SetPasswordActivity.class));
        finish();
    }
    @OnClick(R.id.tv_sign_up_here)
    public void onCLickSignUpHere()
    {
        startActivity(new Intent(this,SignUpActivity.class));
        finish();
    }
    @OnClick(R.id.btn_sign_in_withotp)
    public void onClickSignInWithOtp()
    {
        startActivity(new Intent(this,OTPActivity.class));
        finish();
    }
}
