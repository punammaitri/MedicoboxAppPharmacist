package com.aiprous.medicoboxpharmacist.pharmacist.productlist;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.model.ProductListModel;
import com.aiprous.medicoboxpharmacist.pharmacist.sellertransaction.SellerTransactionActivity;
import com.aiprous.medicoboxpharmacist.utils.SearchableSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PharmacistProductListAdapter extends RecyclerView.Adapter<PharmacistProductListAdapter.ViewHolder> {
    private ArrayList<ProductListModel> mDataArrayList;
    private Context mContext;

    public PharmacistProductListAdapter(Context mContext, ArrayList<ProductListModel> mDataArrayList) {
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

        holder.tv_price.setText(mContext.getResources().getString(R.string.Rs) + "200.00");
        holder.tv_medicine_name.setText(mDataArrayList.get(position).getSku());
        holder.tv_status_confirmed.setText("Qty. Confirmed : " + mDataArrayList.get(position).getQty());
        holder.tv_type.setText("Type: " + mDataArrayList.get(position).getTypeId());


        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowProductListPopup();
            }
        });
    }

    private void ShowProductListPopup() {
        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.alert_for_product_search);
        TextView txtProductList = dialog.findViewById(R.id.txtproductlist);
        EditText edtSearch = dialog.findViewById(R.id.edittext_search_product);

        ((Button) dialog.findViewById(R.id.btnSubmit))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

        ((ImageView) dialog.findViewById(R.id.imgCancel))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
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
        @BindView(R.id.img_edit)
        ImageView img_edit;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}