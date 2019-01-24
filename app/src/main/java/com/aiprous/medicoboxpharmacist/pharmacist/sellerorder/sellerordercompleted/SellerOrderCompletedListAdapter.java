package com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerordercompleted;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.model.AllOrderModel;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.SellerOrderDetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SellerOrderCompletedListAdapter extends RecyclerView.Adapter<SellerOrderCompletedListAdapter.ViewHolder> {

    private ArrayList<AllOrderModel.Completed> mDataArrayList;
    private SellerOrderCompletedFragment mContext;
    private PopupWindow window;

    public SellerOrderCompletedListAdapter(SellerOrderCompletedFragment mContext, ArrayList<AllOrderModel.Completed> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seller_order_completed_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        //holder.imgProduct.setImageResource(mDataArrayList.get(position).getImage());
        holder.txtOrderID.setText(mDataArrayList.get(position).getEntityId());
        holder.txtUsername.setText(mDataArrayList.get(position).getCustomerFirstname() + " " + mDataArrayList.get(position).getCustomerLastname());
        holder.btnProcessing.setText(mDataArrayList.get(position).getStatus());
        holder.txtTotal.setText("\u20B9" + mDataArrayList.get(position).getGrandTotal());

        holder.btn_view_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext.getActivity(), SellerOrderDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mDataArrayList == null) ? 0 : mDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_Order_ID)
        TextView tvOrderID;
        @BindView(R.id.txtOrderIDForItemOrder)
        TextView txtOrderID;
        @BindView(R.id.btn_processing)
        Button btnProcessing;
        @BindView(R.id.btn_view_detail)
        Button btn_view_detail;
        @BindView(R.id.txtUsername)
        TextView txtUsername;
        @BindView(R.id.txtTotal)
        TextView txtTotal;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
