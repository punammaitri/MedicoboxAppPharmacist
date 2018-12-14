package com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerordercompleted;

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
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.SellerOrderListAdapter;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderpending.SellerOrderPendingFragment;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class SellerOrderCompletedFragment extends Fragment {

    RecyclerView rc_seller_list;
    ArrayList<SellerOrderCompletedFragment.ListModel> mlistModelsArray = new ArrayList<>();
    ArrayList<SellerOrderCompletedFragment.SubListModel> mSubListModelsArray = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;

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

        //add static data into List array list
        mlistModelsArray.add(new SellerOrderCompletedFragment.ListModel(R.drawable.ic_menu_manage, "12233232323"));
        mlistModelsArray.add(new SellerOrderCompletedFragment.ListModel(R.drawable.ic_menu_manage, "12233232323"));
        mlistModelsArray.add(new SellerOrderCompletedFragment.ListModel(R.drawable.ic_menu_manage, "12233232323"));

        layoutManager = new LinearLayoutManager(getActivity());
        rc_seller_list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rc_seller_list.setHasFixedSize(true);
        rc_seller_list.setAdapter(new SellerOrderCompletedListAdapter(getActivity(), mlistModelsArray));
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
