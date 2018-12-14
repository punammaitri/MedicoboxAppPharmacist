package com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.invoice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.SellerOrderDetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SellerInvoiceAdapter extends RecyclerView.Adapter<SellerInvoiceAdapter.ViewHolder> {


    private ArrayList<SellerOrderDetailActivity.InvoiceListModel> mDataArrayList;
    private Context mContext;

    public SellerInvoiceAdapter(Context mContext, ArrayList<SellerOrderDetailActivity.InvoiceListModel> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_seller_invoice_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.tvProductName.setText(mDataArrayList.get(position).getOrderId());

        if(position==getItemCount()-1)
        {
            holder.view_order_item.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return (mDataArrayList == null) ? 0 : mDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_product_name)
        TextView tvProductName;
        @BindView(R.id.view_order_item)
        View view_order_item;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
