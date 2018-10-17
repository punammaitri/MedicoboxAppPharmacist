package com.aiprous.medicoboxpharmacist.prescription;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aiprous.medicoboxpharmacist.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PrescriptionOrderSummaryAdapter extends RecyclerView.Adapter<PrescriptionOrderSummaryAdapter.ViewHolder> {


    private ArrayList<PrescriptionOrderSummaryActivity.ListModel> mDataArrayList;
    private Context mContext;

    public PrescriptionOrderSummaryAdapter(Context mContext, ArrayList<PrescriptionOrderSummaryActivity.ListModel> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_summary_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.imgOption.setImageResource(mDataArrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return (mDataArrayList == null) ? 0 : mDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgOption)
        ImageView imgOption;


        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
