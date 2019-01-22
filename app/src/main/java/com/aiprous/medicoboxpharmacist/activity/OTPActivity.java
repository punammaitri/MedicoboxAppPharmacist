package com.aiprous.medicoboxpharmacist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.APIConstant.REGISTER;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.VERIFY_OTP;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;


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
    private String jsonObjectReg;
    private String lContact;
    private Context mContext = this;
    private JSONObject jsonRegObject;

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

        if (getIntent().getStringExtra("jsonObjectReg") != null) {
            jsonObjectReg = getIntent().getStringExtra("jsonObjectReg");
            lContact = getIntent().getStringExtra("lContact");
            
            //get string to json 
            try {
                jsonRegObject = new JSONObject(jsonObjectReg);
                Log.e("regJson",""+jsonRegObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick(R.id.btn_otp_proceed)
    public void onClickOtpProceesd() {

        if (edt_one.length() == 0 && edt_two.length() == 0 && edt_there.length() == 0 && edt_four.length() == 0) {
            Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show();
        } else {

            String getOtp = edt_one.getText().toString() + edt_two.getText().toString() +
                    edt_there.getText().toString() + edt_four.getText().toString();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("mobile", lContact);
                jsonObject.put("otp", getOtp);
                Log.e("data",jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Call otp registration api
            if (!isNetworkAvailable(this)) {
                CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
            } else {
                CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
                CallVerifyOTPAPI(jsonObject, jsonRegObject);
            }
        }
    }

    private void CallVerifyOTPAPI(JSONObject jsonObject, final JSONObject jsonObjectReg) {
        AndroidNetworking.post(VERIFY_OTP)
                .addJSONObjectBody(jsonObject)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response.getString("response"));
                            if (!jsonResponse.isNull("message")) {
                                String status =  jsonResponse.getString("status");
                                String errorMessage = jsonResponse.getString("message");
                                if (status.equals("success")){
                                    CallRegistrationAPI(jsonObjectReg);
                                }else {
                                    Toast.makeText(mContext, "" + errorMessage, Toast.LENGTH_SHORT).show();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        CustomProgressDialog.getInstance().dismissDialog();
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
    }

    private void CallRegistrationAPI(JSONObject jsonObjectReg) {
        AndroidNetworking.post(REGISTER)
                .addJSONObjectBody(jsonObjectReg)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response.getString("response"));
                            String getId =  jsonResponse.getString("id");

                            if (!getId.isEmpty()){
                                Toast.makeText(mContext, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(OTPActivity.this, LoginActivity.class));
                                finish();
                            }else {
                                Toast.makeText(mContext, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                            CustomProgressDialog.getInstance().dismissDialog();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
    }
}
