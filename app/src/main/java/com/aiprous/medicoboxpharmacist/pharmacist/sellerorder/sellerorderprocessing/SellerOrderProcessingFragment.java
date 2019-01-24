package com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderprocessing;

import android.content.Context;
import android.net.Uri;
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
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderpending.SellerOrderPendingFragment;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderpending.SellerOrderPendingListAdapter;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class SellerOrderProcessingFragment extends Fragment {

    RecyclerView rc_seller_list;
    RecyclerView.LayoutManager layoutManager;

    SingletonOrderStatus lsingletonOrderData;
    public ArrayList<AllOrderModel.Processing> data;
    SellerOrderProcessingListAdapter mProcessingListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seller_order_processing, container, false);
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
            if (!lsingletonOrderData.mProcessingArray.isEmpty()) {
                data = lsingletonOrderData.mProcessingArray;
                mProcessingListAdapter=new SellerOrderProcessingListAdapter(SellerOrderProcessingFragment.this, SingletonOrderStatus.getGsonInstance().mProcessingArray);
                rc_seller_list.setAdapter(mProcessingListAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
