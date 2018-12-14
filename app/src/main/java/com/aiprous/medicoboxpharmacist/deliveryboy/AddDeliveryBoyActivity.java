package com.aiprous.medicoboxpharmacist.deliveryboy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDeliveryBoyActivity extends AppCompatActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;
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
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.edt_address_first)
    EditText edtAddressFirst;


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
        String lFirst_name=edtFirstName.getText().toString();
        String lLast_name=edtLastName.getText().toString();
        String lContactNoFirst=edtContactNoFirst.getText().toString();
        String lContactNoSecond=edtContactNoSecond.getText().toString();
        String lEmail_id=edtEmailId.getText().toString();
        String lAddress=edtAddress.getText().toString();
        String lAddressFirst=edtAddressFirst.getText().toString();

        String emailPattern = "[A-Za-z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(lFirst_name.length()==0&&lLast_name.length()==0&&lContactNoFirst.length()==0&&lContactNoSecond.length()==0&&lEmail_id.length()==0&&lAddress.length()==0&&lAddressFirst.length()==0){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        }else if(lFirst_name.length()==0){
            edtFirstName.setError("Please enter first name");
        }else if(lLast_name.length()==0){
            edtLastName.setError("Please enter last name");
        }else if(lContactNoFirst.length()==0){
            edtContactNoFirst.setError("Please enter contact no");
        }else if(lEmail_id.length()==0){
            edtEmailId.setError("Please enter email id");
        }else if(lAddress.length()==0){
           edtAddress.setError("Please enter address");
        }else if(lContactNoFirst.length()<=9){
            edtContactNoFirst.setError("Contact number must be 10 digit");
        }else if (!lEmail_id.matches(emailPattern)) {
            edtEmailId.setError("Please enter valid email id");
        }else {
            //call api
        }

    }
}
