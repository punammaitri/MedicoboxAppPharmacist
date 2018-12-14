package com.aiprous.medicoboxpharmacist.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.MainActivity;
import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.pharmacist.PharmacistSignUpActivity;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup)
    Button btn_signup;
    @BindView(R.id.tv_forgot_password)
    TextView tv_forgot_password;
    @BindView(R.id.tv_sign_up_here)
    TextView tv_sign_up_here;
    @BindView(R.id.edt_mobile_email)
    EditText edtMobileEmail;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    private static final int REQUEST_PERMISSIONS = 20;
    CustomProgressDialog mAlert;
    private String lEmail;
    private String lPass;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        if (isAboveLollipop()) {
            if (!checkAppPermission()) requestPermission();
        }
        init();
    }

    private void init() {
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);

        mAlert = CustomProgressDialog.getInstance();

    }

    private boolean checkAppPermission() {
        int ACCESS_FINE_LOCATION = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        int ACCESS_COARSE_LOCATION = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION);
        int WRITE_EXTERNAL_STORAGE_PERMISSION = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int READ_EXTERNAL_STORAGE_PERMISSION = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        int CAMERA_PERMISSION = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        int INTERNET_PERMISSION = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET);
        int CONTACT_PERMISSION = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS);

        return ACCESS_FINE_LOCATION == PackageManager.PERMISSION_GRANTED && ACCESS_COARSE_LOCATION == PackageManager.PERMISSION_GRANTED && WRITE_EXTERNAL_STORAGE_PERMISSION == PackageManager.PERMISSION_GRANTED && READ_EXTERNAL_STORAGE_PERMISSION == PackageManager.PERMISSION_GRANTED && CAMERA_PERMISSION == PackageManager.PERMISSION_GRANTED && INTERNET_PERMISSION == PackageManager.PERMISSION_GRANTED && CONTACT_PERMISSION == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.INTERNET, Manifest.permission.READ_CONTACTS}, REQUEST_PERMISSIONS);
    }

    private boolean isAboveLollipop() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return true;
        }
        return false;
    }

    @OnClick(R.id.tv_forgot_password)
    public void onClickPassword() {
        startActivity(new Intent(this, SetPasswordActivity.class));
        finish();
    }

    @OnClick(R.id.tv_sign_up_here)
    public void onCLickSignUpHere() {
        startActivity(new Intent(this, PharmacistSignUpActivity.class));
        finish();
    }

    @OnClick(R.id.tv_sign_in_withotp)
    public void onClickSignInWithOtp() {
        startActivity(new Intent(this, OTPActivity.class));
        finish();
    }

    @OnClick(R.id.btn_signup)
    public void onViewClicked() {

       /* lEmail = edtMobileEmail.getText().toString().trim();
        lPass = edtPassword.getText().toString().trim();

        if (lEmail.length() > 0 && lPass.length() > 0) {
            JsonObject jsonObject = new JsonObject();
            //Add Json Object
            jsonObject.addProperty("username", lEmail);
            jsonObject.addProperty("password", lPass);
            //call login API
          AttemptLogin(jsonObject, lEmail, lPass);
        } else if (lEmail.length() == 0) {
            showToast(this, getResources().getString(R.string.error_email));
        } else if (lPass.length() == 0) {
            showToast(this, getResources().getString(R.string.error_pass));
        }*/


        if (!isNetworkAvailable(this)) {
            CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
        } else {
            CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
            //AttemptLogin(jsonObject);
        }

        CustomProgressDialog.getInstance().dismissDialog();

        startActivity(new Intent(LoginActivity.this, MainActivity.class)
                .putExtra("email", "" + lEmail));
    }
}