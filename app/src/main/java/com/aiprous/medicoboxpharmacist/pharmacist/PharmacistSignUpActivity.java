package com.aiprous.medicoboxpharmacist.pharmacist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;

public class PharmacistSignUpActivity extends AppCompatActivity {

    @BindView(R.id.edt_first_name)
    EditText edtFirstName;
    @BindView(R.id.edt_last_name)
    EditText edtLastName;
    @BindView(R.id.edt_contact_no_first)
    EditText edtContactNoFirst;
    @BindView(R.id.edt_contact_no_second)
    EditText edtContactNoSecond;
    @BindView(R.id.edt_email_id)
    EditText edtEmailId;
    @BindView(R.id.edt_name_pharmacy)
    EditText edtNamePharmacy;
    @BindView(R.id.edt_address_first)
    EditText edtAddressFirst;
    @BindView(R.id.edt_address_second)
    EditText edtAddressSecond;
    @BindView(R.id.edt_city)
    EditText edtCity;
    @BindView(R.id.edt_state)
    EditText edtState;
    @BindView(R.id.edt_country)
    EditText edtCountry;
    @BindView(R.id.edt_pincode)
    EditText edtPincode;
    @BindView(R.id.edt_pharmacist_reg_no)
    EditText edtPharmacistRegNo;
    @BindView(R.id.edt_durg)
    EditText edtDurg;
    @BindView(R.id.edt_message)
    EditText edtMessage;
    @BindView(R.id.txtTitle)
    TextView mTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_confirm_password)
    EditText edtConfirmPassword;
    private Context mContext = this;

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
        String lContact_no_second = edtContactNoSecond.getText().toString().trim();
        String lEmail_id = edtEmailId.getText().toString().trim();
        String lName_pharmacy = edtNamePharmacy.getText().toString().trim();
        String lAddress_first = edtAddressFirst.getText().toString();
        String lAddress_second = edtAddressSecond.getText().toString();
        String lCity = edtCity.getText().toString().trim();
        String lState = edtState.getText().toString().trim();
        String lCountry = edtCountry.getText().toString().trim();
        String lPincode = edtPincode.getText().toString().trim();
        String lPharmacistRegNo = edtPharmacistRegNo.getText().toString().trim();
        String lDurg = edtDurg.getText().toString().trim();
        String lPassword = edtPassword.getText().toString().trim();
        String lConPassword = edtConfirmPassword.getText().toString().trim();
        String lmessage = edtMessage.getText().toString().trim();

        if (lFirst_name.length() == 0 && lLast_name.length() == 0 && lContact_no_first.length() == 0 && lEmail_id.length() == 0 && lName_pharmacy.length() == 0 && lAddress_first.length() == 0 && lCity.length() == 0 && lState.length() == 0 && lCountry.length() == 0 && lPincode.length() == 0 && lPharmacistRegNo.length() == 0 && lDurg.length() == 0 && lmessage.length() == 0) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        } else if (lFirst_name.length() == 0) {
            edtFirstName.setError("Please enter first name");
        } else if (lLast_name.length() == 0) {
            edtLastName.setError("Please enter last name");
        } else if (lContact_no_first.length() == 0) {
            edtContactNoFirst.setError("Please enter contact number");
        } else if (lContact_no_second.length() == 0) {
            edtAddressSecond.setError("Please enter contact number");
        } else if (lEmail_id.length() == 0) {
            edtEmailId.setError("Please enter email id");
        } else if (lName_pharmacy.length() == 0) {
            edtNamePharmacy.setError("Enter name of pharmacy");
        } else if (lAddress_first.length() == 0) {
            edtAddressFirst.setError("Please enter address");
        } else if (lAddress_second.length() == 0) {
            edtAddressSecond.setError("Please enter address");
        } else if (lCity.length() == 0) {
            edtCity.setError("Please enter city");
        } else if (lState.length() == 0) {
            edtState.setError("Please enter state");
        } else if (lCountry.length() == 0) {
            edtCountry.setError("Please enter country");
        } else if (lPincode.length() == 0) {
            edtPincode.setError("Please enter pincode");
        } else if (lPharmacistRegNo.length() == 0) {
            edtPharmacistRegNo.setError("Please enter pharmacist registration number");
        } else if (lDurg.length() == 0) {
            edtDurg.setError("Please enter drug license number");
        } else if (lPassword.length() == 0) {
            edtPassword.setError("Enter password");
        } else if (lConPassword.length() == 0) {
            edtConfirmPassword.setError("Enter confirm password");
        } else if (lmessage.length() == 0) {
            edtMessage.setError("Please enter message");
        } else if (!lEmail_id.matches(emailPattern)) {
            edtEmailId.setError("Please enter valid email id");
        } else {
            try {
                JSONObject objCustomer = new JSONObject();
                objCustomer.put("email", lEmail_id);
                objCustomer.put("firstname", lFirst_name);
                objCustomer.put("lastname", lLast_name);
                objCustomer.put("storeId", 1);

                //Add Json Object
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("customer", objCustomer);
                jsonObject.put("password", lPassword);
                jsonObject.put("mobile", lContact_no_first);

                if (!isNetworkAvailable(this)) {
                    CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                } else {
                    CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
                    //AttemptToRegister(jsonObject);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackPressSDescription() {
        finish();
    }
}
