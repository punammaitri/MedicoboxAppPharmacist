package com.aiprous.medicoboxpharmacist.pharmacist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.activity.OTPActivity;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.APIConstant.OTP_REGISTER;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isValidEmailId;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.passwordValidation;


public class PharmacistSignUpActivity extends AppCompatActivity {

    @BindView(R.id.edt_first_name)
    EditText edtFirstName;
    @BindView(R.id.edt_last_name)
    EditText edtLastName;
    @BindView(R.id.edt_contact_no_first)
    EditText edtContactNoFirst;

    @BindView(R.id.edt_email_id)
    EditText edtEmailId;
    @BindView(R.id.edt_name_pharmacy)
    EditText edtNamePharmacy;
    @BindView(R.id.edt_pharmacist_reg_no)
    EditText edtPharmacistRegNo;
    @BindView(R.id.edt_durg)
    EditText edtDurg;

    @BindView(R.id.txtTitle)
    TextView mTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_confirm_password)
    EditText edtConfirmPassword;
    private Context mContext = this;
    ArrayList<String> mStreetArray = new ArrayList<String>();
    private JSONArray jsonArray;
    JSONArray jsonArrayAttribute;
    @BindView(R.id.checkbox)
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_sign_up);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTitle.setText("Sign Up");
        rlayout_cart.setVisibility(View.GONE);

        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);
    }

    @OnClick(R.id.btn_registration)
    public void onViewClicked() {

        String emailPattern = "[A-Za-z0-9._-]+@[a-z]+\\.+[a-z]+";

        String lFirst_name = edtFirstName.getText().toString().trim();
        String lLast_name = edtLastName.getText().toString().trim();
        String lContact_no_first = edtContactNoFirst.getText().toString().trim();
        String lEmail_id = edtEmailId.getText().toString().trim();
        String lName_pharmacy = edtNamePharmacy.getText().toString().trim();
        String lPharmacistRegNo = edtPharmacistRegNo.getText().toString().trim();
        String lDurg = edtDurg.getText().toString().trim();
        String lPassword = edtPassword.getText().toString().trim();
        String lConPassword = edtConfirmPassword.getText().toString().trim();

        if (lFirst_name.length() == 0 && lLast_name.length() == 0 && lContact_no_first.length() == 0 && lEmail_id.length() == 0 && lName_pharmacy.length() == 0 && lPharmacistRegNo.length() == 0 && lDurg.length() == 0) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        } else if (lFirst_name.length() == 0) {
            edtFirstName.setError("Please enter first name");
        } else if (lLast_name.length() == 0) {
            edtLastName.setError("Please enter last name");
        } else if (lContact_no_first.length() == 0) {
            edtContactNoFirst.setError("Please enter contact number");
        } else if (!isValidEmailId(edtEmailId)) {
            edtEmailId.setError("Invalid email address");
        } else if (lName_pharmacy.length() == 0) {
            edtNamePharmacy.setError("Enter name of pharmacy");
        } else if (lPharmacistRegNo.length() == 0) {
            edtPharmacistRegNo.setError("Please enter pharmacist registration number");
        } else if (lDurg.length() == 0) {
            edtDurg.setError("Please enter drug license number");
        } else if (!passwordValidation(mContext, lPassword, edtPassword)) {
            Toast.makeText(mContext, "Password should contains one uppercase,lowercase,special character,number & should be greater than 7 character .", Toast.LENGTH_SHORT).show();
        } else if (!lPassword.equals(lConPassword)) {
            Toast.makeText(mContext, "Password mismatch", Toast.LENGTH_SHORT).show();
        } else if (!checkbox.isChecked()) {
            Toast.makeText(mContext, "Please select term &amp; conditions", Toast.LENGTH_SHORT).show();
        } else {

            try {

            /*    mStreetArray.clear();
                mStreetArray.add(lAddress_first);
                mStreetArray.add(lAddress_second);
                jsonArray = new JSONArray(mStreetArray);


                JSONObject jsonAddress  = new JSONObject();
                jsonAddress.put("city",lCity);
                jsonAddress.put("company",lPharmacistName);
                jsonAddress.put("country_id","IN");
                jsonAddress.put("default_billing","1");
                jsonAddress.put("default_shipping","1");
                jsonAddress.put("fax","fax");
                jsonAddress.put("firstname",lFirst_name);
                jsonAddress.put("lastname",lLast_name);
                jsonAddress.put("postcode",lPincode);
                jsonAddress.put("regionId","553");
                jsonAddress.put("street", jsonArray);
                jsonAddress.put("telephone",lContact_no_first);
                JSONArray jsonAddressArray= new JSONArray();
                jsonAddressArray.put(jsonAddress);*/


                JSONObject jsonObjectAttribute1 = new JSONObject();
                JSONObject jsonObjectAttribute2 = new JSONObject();
                JSONObject jsonObjectAttribute3 = new JSONObject();

                jsonObjectAttribute1.put("attributeCode", "mobile_number");
                jsonObjectAttribute1.put("value", lContact_no_first);

                jsonObjectAttribute2.put("attributeCode", "pharmacist_reg_no");
                jsonObjectAttribute2.put("value", lPharmacistRegNo);

                jsonObjectAttribute3.put("attributeCode", "drug_license_no");
                jsonObjectAttribute3.put("value", lDurg);

                jsonArrayAttribute = new JSONArray();
                jsonArrayAttribute.put(jsonObjectAttribute1);
                jsonArrayAttribute.put(jsonObjectAttribute2);
                jsonArrayAttribute.put(jsonObjectAttribute3);

                //*****************for customer ******************//
                JSONObject objCustomer = new JSONObject();
                objCustomer.put("email", lEmail_id);
                objCustomer.put("firstname", lFirst_name);
                objCustomer.put("lastname", lLast_name);
                objCustomer.put("store_id", 1);
                objCustomer.put("customAttributes", jsonArrayAttribute);

                JSONObject jsonObjectReg = new JSONObject();
                jsonObjectReg.put("customer", objCustomer);
                jsonObjectReg.put("password", lPassword);
                Log.e("data", "" + jsonObjectReg.toString());

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("mobile", lContact_no_first);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Call otp registration api
                if (!isNetworkAvailable(this)) {
                    CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                } else {
                    CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
                    CallOTPRegisterAPI(jsonObject, jsonObjectReg, lContact_no_first);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void CallOTPRegisterAPI(final JSONObject jsonObject, final JSONObject jsonObjectReg, final String lContact_no_first) {
        AndroidNetworking.post(OTP_REGISTER)
                .addJSONObjectBody(jsonObject)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response.getString("response"));
                            String status = jsonResponse.getString("status");
                            if (status.equals("success")) {
                                Intent intent = new Intent(PharmacistSignUpActivity.this, OTPActivity.class);
                                intent.putExtra("jsonObjectReg", jsonObjectReg.toString());
                                intent.putExtra("lContact", lContact_no_first);
                                startActivity(intent);
                                finish();
                            } else {
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

    @OnClick(R.id.rlayout_back_button)
    public void BackPressSDescription() {

    }
}
