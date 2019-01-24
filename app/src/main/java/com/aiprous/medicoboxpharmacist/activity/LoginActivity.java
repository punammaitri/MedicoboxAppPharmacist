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
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.MainActivity;
import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.application.MedicoboxApp;
import com.aiprous.medicoboxpharmacist.pharmacist.PharmacistSignUpActivity;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.APIConstant.Authorization;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.BEARER;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.GETUSERINFO;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.LOGIN;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isValidEmailId;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.showToast;


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
    private String getResponse;
    private String getMobileNumber;

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

        lEmail = edtMobileEmail.getText().toString().trim();
        lPass = edtPassword.getText().toString().trim();

        if (lEmail.length() == 0) {
            showToast(this, getResources().getString(R.string.error_email));
        } else if (lPass.length() == 0) {
            showToast(this, getResources().getString(R.string.error_pass));
        } else {
            if (!(edtMobileEmail.length() ==0)) {
                if (!isValidEmailId(edtMobileEmail)) {
                    showToast(this, "Please enter valid email id");
                } else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username", "peters@mitash.com");
                        jsonObject.put("password", "Peter.s@888");
                        Log.e("data",""+jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    /*try {
                        jsonObject.put("username", lEmail);
                        jsonObject.put("password", lPass);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/

                    if (!isNetworkAvailable(this)) {
                        CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                    } else {
                        CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
                        AttemptLogin(jsonObject);
                    }
                }
            }
        }
    }

    private void AttemptLogin(JSONObject jsonObject) {
        AndroidNetworking.post(LOGIN)
                .addJSONObjectBody(jsonObject) // posting json
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        try {
                            getResponse = response.getString("response");
                            if (!getResponse.contains("message")) {
                                if (!isNetworkAvailable(LoginActivity.this)) {
                                    CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                                } else {
                                    if (!isNetworkAvailable(LoginActivity.this)) {
                                        CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                                    } else {
                                        getUserInfo(getResponse);
                                    }
                                }
                            } else {
                                // for removing braces
                                CustomProgressDialog.getInstance().dismissDialog();
                                String afterRemoveBrace = getResponse.replace("{", "").replace("}", "");
                                StringTokenizer getMessage = new StringTokenizer(afterRemoveBrace, ":");
                                String msg = getMessage.nextToken();
                                String error_msg = getMessage.nextToken();
                                Toast.makeText(LoginActivity.this, "Check login credentials", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Toast.makeText(LoginActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
    }
    private void getUserInfo(final String bearerToken) {
        AndroidNetworking.get(GETUSERINFO)
                .addHeaders(Authorization, BEARER + bearerToken)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response

                        try {
                            JsonObject getAllResponse = (JsonObject) new JsonParser().parse(response.toString());
                            JsonObject responseObject = getAllResponse.get("response").getAsJsonObject();
                            String status = responseObject.get("status").getAsString();
                            if (status.equals("success")) {

                                MedicoboxApp.onSaveBearer(bearerToken);
                                JsonObject responseObjects = responseObject.get("data").getAsJsonObject();
                                String getId = responseObjects.get("id").getAsString();
                                String getGroupId = responseObjects.get("group_id").getAsString();
                                String getEmail = responseObjects.get("email").getAsString();
                                String getFirstname = responseObjects.get("firstname").getAsString();
                                String getLastname = responseObjects.get("lastname").getAsString();
                                String getStoreId = responseObjects.get("store_id").getAsString();
                                String getWebsiteId = responseObjects.get("website_id").getAsString();
                                JsonArray custom_attributes_array = responseObjects.get("custom_attributes").getAsJsonArray();

                                if (custom_attributes_array != null) {
                                    for (int j = 0; j < custom_attributes_array.size(); j++) {
                                        JsonObject customObject = custom_attributes_array.get(j).getAsJsonObject();
                                        getMobileNumber = customObject.get("value").getAsString();
                                    }
                                }
                                MedicoboxApp.onSaveLoginDetail(getId, getFirstname, getLastname, getMobileNumber, getEmail);
                                Toast.makeText(mContext, "Login successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class)
                                        .putExtra("email", "" + getEmail));
                                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                                finish();
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Toast.makeText(LoginActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
    }
}