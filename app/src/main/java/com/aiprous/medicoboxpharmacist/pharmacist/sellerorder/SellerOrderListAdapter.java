package com.aiprous.medicoboxpharmacist.pharmacist.sellerorder;

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
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.sellerorderpending.SellerOrderPendingFragment;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.SellerOrderDetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SellerOrderListAdapter extends RecyclerView.Adapter<SellerOrderListAdapter.ViewHolder> {

    private ArrayList<SellerOrderPendingFragment.ListModel> mDataArrayList;
    private Context mContext;
    private PopupWindow window;

    public SellerOrderListAdapter(Context mContext, ArrayList<SellerOrderPendingFragment.ListModel> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seller_order_processing_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        //holder.imgProduct.setImageResource(mDataArrayList.get(position).getImage());
        holder.txtOrderID.setText(mDataArrayList.get(position).getOrderId());

        holder.btn_view_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,SellerOrderDetailActivity.class));
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


        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
