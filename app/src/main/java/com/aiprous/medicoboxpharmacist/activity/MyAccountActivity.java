package com.aiprous.medicoboxpharmacist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.prescription.PrescriptionChooseDeliveryAddressActivity;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAccountActivity extends AppCompatActivity {


    @BindView(R.id.searchview_medicine)
    SearchView searchview_medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        searchview_medicine.setFocusable(false);

        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);
    }

    @OnClick(R.id.tv_edit_profile)
    public void onClickEditProfile() {
        startActivity(new Intent(this, EditProfileActivity.class));
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackPressDetail() {
        finish();
    }

    @OnClick(R.id.tv_change_delivery_address)
    public void ChangeDeliveryAddress() {
        startActivity(new Intent(this, PrescriptionChooseDeliveryAddressActivity.class));
    }
}
