package com.aiprous.medicoboxpharmacist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.google.android.gms.common.api.Response;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;


public class ForgotPasswordActivity extends AppCompatActivity {

    @BindView(R.id.btn_set_password)
    Button btn_set_password;
    CustomProgressDialog mAlert;
    @BindView(R.id.edt_verification_code)
    EditText edtVerificationCode;
    @BindView(R.id.edt_new_password)
    EditText edtNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        init();
    }

    ;

    private void init() {
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);
        mAlert = CustomProgressDialog.getInstance();
        JsonObject jsonObject = new JsonObject();
        //Add Json Object
        jsonObject.addProperty("confirmationKey", "1");

//        AttemptToConfirmKey(jsonObject);
    }

    @OnClick(R.id.btn_set_password)
    public void onClickSetPassword() {
        
        String lVerificationCode=edtVerificationCode.getText().toString();
        String lNewPassword=edtNewPassword.getText().toString();
        
        if(lVerificationCode.length()==0&&lNewPassword.length()==0)
        {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }else if(lVerificationCode.length()==0){
            edtVerificationCode.setError("Please enter verification code");
        }
        else if(lNewPassword.length()==0){
            edtNewPassword.setError("Please enter new password");
        }else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
