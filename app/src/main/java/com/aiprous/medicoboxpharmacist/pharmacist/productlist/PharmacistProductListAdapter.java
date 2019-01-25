package com.aiprous.medicoboxpharmacist.pharmacist.productlist;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.model.ProductListModel;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.SellerOrderDetailActivity;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;

public class PharmacistProductListAdapter extends RecyclerView.Adapter<PharmacistProductListAdapter.ViewHolder> {
    private ArrayList<ProductListModel> mDataArrayList;
    private PharmacistProductListActivity mContext;
    private UpdateQuantity mInterface;


    public PharmacistProductListAdapter(PharmacistProductListActivity mContext, ArrayList<ProductListModel> mDataArrayList) {
        this.mContext = mContext;
        this.mDataArrayList = mDataArrayList;
        this.mInterface = mContext;
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
                ShowProductListPopup(mDataArrayList.get(position).getEntityId(), mDataArrayList.get(position).getSku());
            }
        });
    }

    private void ShowProductListPopup(final String entityId, String sku) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.alert_for_product_search);
        TextView txtProductname = dialog.findViewById(R.id.txtProductname);
        final EditText edtSearch = dialog.findViewById(R.id.edittext_search_product);

        txtProductname.setText(sku);

        ((Button) dialog.findViewById(R.id.btnCancel))
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

        ((Button) dialog.findViewById(R.id.btnUpdate))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (!(edtSearch.getText().length() == 0)) {
                            CallUpdateProductQuantity(entityId, edtSearch.getText().toString());
                            dialog.dismiss();
                        } else {
                            Toast.makeText(mContext, "Please add quantity", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        dialog.show();
    }

    private void CallUpdateProductQuantity(String productId, String quantity) {
        if (!isNetworkAvailable(mContext)) {
            CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
        } else {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("pro_id", productId);
                jsonObject.put("pro_quantity", quantity);
                mContext.updateQuantity(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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

    public interface UpdateQuantity {
        public void updateQuantity(JSONObject jsonObject);
    }
}