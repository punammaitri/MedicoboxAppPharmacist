package com.aiprous.medicoboxpharmacist.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.EditText;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.searchview_medicine)
    SearchView searchview_medicine;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        searchview_medicine.setFocusable(false);

        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);
    }

    @OnClick(R.id.btn_save)
    public void onSave() {

        String emailPattern = "[A-Za-z0-9._-]+@[a-z]+\\.+[a-z]+";

        String lFirst_name=edtFirstName.getText().toString().trim();
        String  lLast_name=edtLastName.getText().toString().trim();
        String  lContact_no_first=edtContactNoFirst.getText().toString().trim();
        String lContact_no_second=edtContactNoSecond.getText().toString().trim();
        String lemail_id=edtEmailId.getText().toString().trim();
        String lname_pharmacy=edtNamePharmacy.getText().toString().trim();
        String lAddress_first=edtAddressFirst.getText().toString();
        String lAddress_second=edtAddressSecond.getText().toString();
        String lcity=edtCity.getText().toString().trim();
        String lState=edtState.getText().toString().trim();
        String lCountry=edtCountry.getText().toString().trim();
        String lPincode=edtPincode.getText().toString().trim();
        String lPharmacistRegNo=edtPharmacistRegNo.getText().toString().trim();
        String lDurg=edtDurg.getText().toString().trim();
        String lmessage=edtMessage.getText().toString().trim();


        if(lFirst_name.length()==0&&lLast_name.length()==0&&lContact_no_first.length()==0&&lemail_id.length()==0&&lname_pharmacy.length()==0&&lAddress_first.length()==0&&lcity.length()==0&&lState.length()==0&&lCountry.length()==0&&lPincode.length()==0&&lPharmacistRegNo.length()==0&&lDurg.length()==0&&lmessage.length()==0){

            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        }else if(lFirst_name.length()==0){

            edtFirstName.setError("Please enter first name");
        }else if(lLast_name.length()==0){
            edtLastName.setError("Please enter last name");
        }else if(lContact_no_first.length()==0){
            edtContactNoFirst.setText("Please enter contact number");
        }else if(lemail_id.length()==0){
            edtEmailId.setError("Please enter email id");
        }else if(lname_pharmacy.length()==0){
            edtNamePharmacy.setError("Enter name of pharmacy");
        }else if(lAddress_first.length()==0){
            edtAddressFirst.setError("Please enter address");
        }else if(lcity.length()==0){
            edtCity.setError("Please enter city");
        }else if(lState.length()==0){
            edtState.setText("Please enter state");
        }else if(lCountry.length()==0){
            edtCountry.setError("Please enter country");
        }else if(lPincode.length()==0){
            edtPincode.setError("Please enter pincode");
        }else if(lPharmacistRegNo.length()==0){
            edtPharmacistRegNo.setError("Please enter pharmacist registration number");
        }else if(lDurg.length()==0){
            edtDurg.setError("Please enter drug license number");
        }else if(lmessage.length()==0){
            edtMessage.setError("Please enter message");
        }else if(lContact_no_first.length()<=9){
            edtContactNoFirst.setError("Contact number should be 10 digit");
        }else if (!lemail_id.matches(emailPattern)) {
            edtEmailId.setError("Please enter valid email id");
        }
        else {
            //call api
        }
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackPressSProfile() {
        finish();
    }
}
