package com.aiprous.medicoboxpharmacist.pharmacist.productlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.pharmacist.sellertransaction.SellerTransactionActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PharmacistProductListAdapter extends RecyclerView.Adapter<PharmacistProductListAdapter.ViewHolder> {
    private ArrayList<SellerTransactionActivity.SellerTransactionModel> mDataArrayList;
    private Context mContext;

    public PharmacistProductListAdapter(Context mContext, ArrayList<SellerTransactionActivity.SellerTransactionModel> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pharmacist_product_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.tv_price.setText(mContext.getResources().getString(R.string.Rs)+"200.00");
    }

    @Override
    public int getItemCount() {
        return (mDataArrayList == null) ? 0 : mDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_medicine)
        ImageView img_medicine;
        @BindView(R.id.tv_medicine_name)
        TextView tv_medicine_name;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_type)
        TextView tv_type;
        @BindView(R.id.tv_status)
        TextView tv_status;
        @BindView(R.id.tv_status_confirmed)
        TextView tv_status_confirmed;
        @BindView(R.id.tv_status_pending)
        TextView tv_status_pending;
        @BindView(R.id.tv_qty)
        TextView tv_qty;
        @BindView(R.id.tv_earned_amount)
        TextView tv_earned_amount;


        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
