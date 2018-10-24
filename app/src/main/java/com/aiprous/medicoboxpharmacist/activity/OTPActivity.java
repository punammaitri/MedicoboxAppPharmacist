package com.aiprous.medicoboxpharmacist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.MainActivity;
import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OTPActivity extends AppCompatActivity {

    @BindView(R.id.btn_otp_proceed)
    Button btn_otp_proceed;
    @BindView(R.id.edt_one)
    EditText edt_one;
    @BindView(R.id.edt_two)
    EditText edt_two;
    @BindView(R.id.edt_there)
    EditText edt_there;
    @BindView(R.id.edt_four)
    EditText edt_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);

        edt_one.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (s.length() == 1) {
                    edt_two.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });

        edt_two.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    edt_there.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
        edt_there.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    edt_four.requestFocus();
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
        });
    }

    @OnClick(R.id.btn_otp_proceed)
    public void onClickOtpProceesd() {

        if(edt_one.length()==0&&edt_two.length()==0&&edt_there.length()==0&&edt_four.length()==0)
        {
            Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show();
        }else {
            //api call
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}
