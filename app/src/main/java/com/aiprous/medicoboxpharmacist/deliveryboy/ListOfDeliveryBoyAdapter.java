package com.aiprous.medicoboxpharmacist.deliveryboy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.model.ListOfDeliveryBoyModel;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListOfDeliveryBoyAdapter extends RecyclerView.Adapter<ListOfDeliveryBoyAdapter.ViewHolder> {


    private ArrayList<ListOfDeliveryBoyModel> mDataArrayList;
    private Context mContext;

    public ListOfDeliveryBoyAdapter(Context mContext, ArrayList<ListOfDeliveryBoyModel> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_order_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.imgView.setImageResource(R.drawable.user);
        holder.txtDeliveryBoyName.setText(mDataArrayList.get(position).getName());

        holder.llayoutListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DeliveryBoyDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mDataArrayList == null) ? 0 : mDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view)
        CircularImageView imgView;
        @BindView(R.id.txt_delivery_boy_name)
        TextView txtDeliveryBoyName;
        @BindView(R.id.llayout_listing)
        LinearLayout llayoutListing;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
