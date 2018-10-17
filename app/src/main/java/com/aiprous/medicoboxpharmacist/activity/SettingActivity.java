package com.aiprous.medicoboxpharmacist.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.txtTitle)
    TextView mTitle;
    @BindView(R.id.rlayout_cart)
    TextView rlayout_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        mTitle.setText("Settings");
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);

    }
}