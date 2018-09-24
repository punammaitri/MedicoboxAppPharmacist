package com.aiprous.medicobox.instaorder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import medicobox.aiprous.com.medicobox.R;


public class InstaProductDetailAdapter extends RecyclerView.Adapter<InstaProductDetailAdapter.ViewHolder> {


    private ArrayList<InstaProductDetailActivity.ListModel> mDataArrayList;
    private Context mContext;

    public InstaProductDetailAdapter(Context mContext, ArrayList<InstaProductDetailActivity.ListModel> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.insta_product_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.imgProduct.setImageResource(mDataArrayList.get(position).getImage());
        holder.tvMedicineName.setText(mDataArrayList.get(position).getMedicineName());
        holder.tvContent.setText(mDataArrayList.get(position).getValue());
        holder.tvMrp.setText(mContext.getResources().getString(R.string.Rs) + mDataArrayList.get(position).getMrp() + "  " + mDataArrayList.get(position).getDiscount() + "%" + "OFF");
        holder.tvPrice.setText(mContext.getResources().getString(R.string.Rs) + mDataArrayList.get(position).getPrice());

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, InstaAddNewListActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return (mDataArrayList == null) ? 0 : mDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.llMain)
        LinearLayout llMain;
        @BindView(R.id.img_product)
        ImageView imgProduct;
        @BindView(R.id.tv_medicine_name)
        TextView tvMedicineName;
        @BindView(R.id.img_wishlist_icon)
        ImageView imgWishlistIcon;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_mrp)
        TextView tvMrp;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.txt_add_to_insta_list)
        TextView txtAddToInstaList;


        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
