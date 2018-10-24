package com.aiprous.medicoboxpharmacist.pharmacist.sellertransaction;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SellerTransactionsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.searchview_medicine)
    SearchView searchview_medicine;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.tv_total_price)
    TextView tv_total_price;
    @BindView(R.id.tv_total_tax)
    TextView tv_total_tax;
    @BindView(R.id.tv_total_shipping)
    TextView tv_total_shipping;
    @BindView(R.id.tv_commission)
    TextView tv_commission;
    @BindView(R.id.tv_sub_total)
    TextView tv_sub_total;
    private Context mcontext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_transactions_details);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        searchview_medicine.setFocusable(false);

        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);

        tv_price.setText(mcontext.getResources().getString(R.string.Rs) + "278.00");
        tv_total_price.setText(mcontext.getResources().getString(R.string.Rs) + "278.00");
        tv_total_tax.setText(mcontext.getResources().getString(R.string.Rs) + "0.00");
        tv_total_shipping.setText(mcontext.getResources().getString(R.string.Rs) + "0.00");
        tv_commission.setText(mcontext.getResources().getString(R.string.Rs) + "0.00");
        tv_sub_total.setText(mcontext.getResources().getString(R.string.Rs) + "278.00");


    }
    @OnClick(R.id.rlayout_back_button)
    public void BackPressSDescription() {
        finish();
    }

}
