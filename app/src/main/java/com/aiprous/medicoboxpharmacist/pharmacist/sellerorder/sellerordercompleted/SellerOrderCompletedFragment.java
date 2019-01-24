package com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerordercompleted;

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

public class SellerOrderCompletedFragment extends Fragment {

    RecyclerView rc_seller_list;
    SingletonOrderStatus lsingletonOrderData;
    public ArrayList<AllOrderModel.Completed> data;
    SellerOrderCompletedListAdapter mSellerCompletedListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seller_order_completed, container, false);
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
            if (!lsingletonOrderData.mCompletedArray.isEmpty()) {
                data = lsingletonOrderData.mCompletedArray;
                mSellerCompletedListAdapter=new SellerOrderCompletedListAdapter(SellerOrderCompletedFragment.this, SingletonOrderStatus.getGsonInstance().mCompletedArray);
                rc_seller_list.setAdapter(mSellerCompletedListAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class ListModel {
        int image;
        String orderId;

        public ListModel(int image, String orderId) {
            this.image = image;
            this.orderId = orderId;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

    }

    public class SubListModel {
        int image;
        String product_name;

        public SubListModel(int image, String product_name) {
            this.image = image;
            this.product_name = product_name;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }
    }
}
