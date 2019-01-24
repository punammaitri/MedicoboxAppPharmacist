package com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderpending;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.designpattern.SingletonOrderStatus;
import com.aiprous.medicoboxpharmacist.model.AllOrderModel;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class SellerOrderPendingFragment extends Fragment {

    RecyclerView rc_seller_list;
    RecyclerView.LayoutManager layoutManager;
    SingletonOrderStatus lsingletonOrderData;
    public ArrayList<AllOrderModel.Pending> data;
    SellerOrderPendingListAdapter mSellerPendingListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seller_order_pending, container, false);
        rc_seller_list = view.findViewById(R.id.rc_seller_list);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(getActivity());

        rc_seller_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        lsingletonOrderData  =SingletonOrderStatus.getGsonInstance();
        try {
            if (!lsingletonOrderData.mPendingArray.isEmpty()) {
                data = lsingletonOrderData.mPendingArray;
                mSellerPendingListAdapter=new SellerOrderPendingListAdapter(SellerOrderPendingFragment.this, SingletonOrderStatus.getGsonInstance().mPendingArray);
                rc_seller_list.setAdapter(mSellerPendingListAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
