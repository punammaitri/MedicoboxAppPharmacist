package com.aiprous.medicoboxpharmacist.deliveryboy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.MainActivity;
import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.activity.LoginActivity;
import com.aiprous.medicoboxpharmacist.application.MedicoboxApp;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.APIConstant.ADD_DELIVERY_BOY;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.Authorization;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.BEARER;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isValidEmailId;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.showToast;

public class AddDeliveryBoyActivity extends AppCompatActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_email_id)
    EditText edtEmailId;
    @BindView(R.id.edt_mobile)
    EditText edtMobile;
    @BindView(R.id.edt_vehicle_type)
    EditText edtVehicleType;
    @BindView(R.id.edt_vehicle_number)
    EditText edtVehicleNumber;
    @BindView(R.id.edt_password)
    EditText edtPassword;

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery_boy);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        txtTitle.setText("Add Delivery Boy");
        rlayout_cart.setVisibility(View.GONE);

        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackPressSDescription() {
        finish();
    }

    @OnClick(R.id.btn_add)
    public void onAddDeliveryBoy() {
        String lName = edtName.getText().toString();
        String lEmailId = edtEmailId.getText().toString();
        String lMobile = edtMobile.getText().toString();
        String lVehicleType = edtVehicleType.getText().toString();
        String lVehicleNumber = edtVehicleNumber.getText().toString();
        String lPassword = edtPassword.getText().toString();

        String emailPattern = "[A-Za-z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (lName.length() == 0 && lEmailId.length() == 0 && lMobile.length() == 0 && lVehicleType.length() == 0 && lVehicleNumber.length() == 0 && lPassword.length() == 0) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        } else if (lName.length() == 0) {
            edtName.setError("Please enter name");
        } else if (!isValidEmailId(edtEmailId)) {
            showToast(this, "Please enter valid email id");
        } else if (lMobile.length() < 10) {
            edtMobile.setError("Please enter contact no");
        } else if (lVehicleType.length() == 0) {
            edtVehicleType.setError("Please enter vehicle type");
        } else if (lVehicleNumber.length() == 0) {
            edtVehicleNumber.setError("Please enter vehicle number");
        } else if (lPassword.length() ==0) {
            edtPassword.setError("Please enter password");
        } else {
            //call api
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("name", lName);
                jsonObject.put("email", lEmailId);
                jsonObject.put("mobile", lMobile);
                jsonObject.put("vehicle_type", lVehicleType);
                jsonObject.put("vehicle_no", lVehicleNumber);
                jsonObject.put("password", lPassword);
                jsonObject.put("status", "0");
                Log.e("data", "" + jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (!isNetworkAvailable(this)) {
                CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
            } else {
                CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
                AttemptAddDeliveryBoy(jsonObject);
            }
        }

    }

    private void AttemptAddDeliveryBoy(JSONObject jsonObject) {
        AndroidNetworking.post(ADD_DELIVERY_BOY)
                .addJSONObjectBody(jsonObject)
                .addHeaders(Authorization, BEARER + MedicoboxApp.onGetBearer())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        JsonObject getAllResponse = (JsonObject) new JsonParser().parse(response.toString());
                        JsonObject responseObject = getAllResponse.get("response").getAsJsonObject();
                        String status = responseObject.get("status").getAsString();
                        String msg = responseObject.get("msg").getAsString();

                        if (status.equals("success")) {
                            edtName.setText("");
                            edtEmailId.setText("");
                            edtMobile.setText("");
                            edtVehicleType.setText("");
                            edtVehicleNumber.setText("");
                            edtPassword.setText("");
                            Toast.makeText(mContext, "" + msg, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(mContext, "" + msg, Toast.LENGTH_SHORT).show();
                        }
                        CustomProgressDialog.getInstance().dismissDialog();
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Toast.makeText(AddDeliveryBoyActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
    }
}