package com.aiprous.medicobox.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiprous.medicobox.R;
import com.aiprous.medicobox.fragment.HomeFragment;
import com.aiprous.medicobox.instaorder.InstaAddNewListActivity;
import com.aiprous.medicobox.instaorder.InstaProductDetailActivity;
import com.aiprous.medicobox.prescription.ChooseDeliveryAddressActivity;
import com.aiprous.medicobox.prescription.OrderSummaryActivity;
import com.aiprous.medicobox.prescription.UploadPrescriptionActivity;
import com.aiprous.medicobox.prescription.UploadPrescriptionOptionActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FeatureProductAdapter extends RecyclerView.Adapter<FeatureProductAdapter.ViewHolder> {
    private ArrayList<HomeFragment.Product> mDataArrayList;
    private Context mContext;

    public FeatureProductAdapter(Context mContext, ArrayList<HomeFragment.Product> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext())
        //        .inflate(R.layout.feature_product_item, parent, false);
        // return new ViewHolder(view);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_product_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.img_product.setImageResource(mDataArrayList.get(position).getProduct_image());
        holder.tv_medicine_name.setText(mDataArrayList.get(position).getProduct_name());
        holder.tv_product_mrp.setText(mContext.getResources().getString(R.string.Rs) + mDataArrayList.get(position).getProduct_mrp());
        holder.tv_product_mrp.setPaintFlags(holder.tv_product_mrp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tv_product_discount.setText(mDataArrayList.get(position).getProduct_discount() + "off");
        holder.tv_product_price.setText(mContext.getResources().getString(R.string.Rs) + mDataArrayList.get(position).getProduct_price());

        holder.cardRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, InstaAddNewListActivity.class));
                //((Activity)mContext).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mDataArrayList == null) ? 0 : mDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_product)
        ImageView img_product;
        @BindView(R.id.tv_product_name)
        TextView tv_medicine_name;
        @BindView(R.id.tv_product_mrp)
        TextView tv_product_mrp;
        @BindView(R.id.tv_product_price)
        TextView tv_product_price;
        @BindView(R.id.cardRating)
        CardView cardRating;
        @BindView(R.id.tv_product_discount)
        TextView tv_product_discount;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
