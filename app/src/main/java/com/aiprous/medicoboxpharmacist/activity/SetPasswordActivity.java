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
import com.google.gson.JsonPrimitive;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.showToast;


public class SetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.btn_proceed_set_password)
    Button btn_proceed_set_password;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    private String lEmail;
    CustomProgressDialog mAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);

        mAlert = CustomProgressDialog.getInstance();

    }


    @OnClick(R.id.btn_proceed_set_password)
    public void onCickSetPassword() {

        lEmail = edtEmail.getText().toString().trim();

        if (lEmail.length() > 0) {
            JsonObject jsonObject = new JsonObject();
            //Add Json Object
            jsonObject.addProperty("customerEmail", lEmail);
            jsonObject.addProperty("websiteId", 1);
            //AttemptSetPassword(jsonObject, lEmail, 1);
        } else if (lEmail.length() == 0) {
            showToast(this, getResources().getString(R.string.error_email));
        }

    }
}
