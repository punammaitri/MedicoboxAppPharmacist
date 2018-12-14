package com.aiprous.medicoboxpharmacist.pharmacist.sellerorder;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerordercompleted.SellerOrderCompletedFragment;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderpending.SellerOrderPendingFragment;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderprocessing.SellerOrderProcessingFragment;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.invoice.SellerInvoiceFragment;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SellerOrderTabActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView mTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_order_tab);
        ButterKnife.bind(this);

        mTitle.setText("Latest Order");
        rlayout_cart.setVisibility(View.VISIBLE);
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {
                case 0:
                    SellerOrderPendingFragment sellerOrderPendingFragment = new SellerOrderPendingFragment();
                    return sellerOrderPendingFragment;

                case 1:
                    SellerOrderProcessingFragment sellerOrderProcessingFragment = new SellerOrderProcessingFragment();
                    return sellerOrderProcessingFragment;
                case 2:
                    SellerOrderCompletedFragment orderCompletedFragment = new SellerOrderCompletedFragment();
                    return orderCompletedFragment;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Pending";
                case 1:
                    return "Proccessing";
                case 2:
                    return "Completed";
            }
            return null;
        }
    }


    @OnClick(R.id.rlayout_back_button)
    public void BackButton() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}