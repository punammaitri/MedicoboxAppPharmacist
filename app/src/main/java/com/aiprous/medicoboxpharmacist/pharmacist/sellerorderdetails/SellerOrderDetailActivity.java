package com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.invoice.SellerInvoiceAdapter;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.itemorder.SellerItemOrderAdapter;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.SearchableSpinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SellerOrderDetailActivity extends AppCompatActivity {

    @BindView(R.id.rec_sellerItemOrder)
    RecyclerView rec_sellerItemOrder;

    @BindView(R.id.rec_sellerInvoice)
    RecyclerView rec_sellerInvoice;

    ArrayList<ListModel> mlistModelsArray = new ArrayList<>();
    ArrayList<InvoiceListModel> mInvoiceModelsArray = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;


    @BindView(R.id.relDeliveryBoyList)
    RelativeLayout relDeliveryBoyList;
    @BindView(R.id.btnCreateInvoice)
    Button btnCreateInvoice;
    @BindView(R.id.btnSendEmail)
    Button btnSendEmail;
    @BindView(R.id.btnCancelOrder)
    Button btnCancelOrder;
    @BindView(R.id.btnPrints)
    Button btnPrints;
    ArrayAdapter<String> mItemOrder;
    @BindView(R.id.txtTitle)
    TextView mTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;
    @BindView(R.id.linearItemOrdered)
    LinearLayout linearItemOrdered;
    @BindView(R.id.linearInvoice)
    LinearLayout linearInvoice;
    @BindView(R.id.btnOrderItem)
    Button btnOrderItem;
    @BindView(R.id.btnInvoice)
    Button btnInvoice;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_order_detail);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        mTitle.setText("Order Details");
        rlayout_cart.setVisibility(View.GONE);
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);

        //add static data into List array list
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));

        layoutManager = new LinearLayoutManager(this);
        rec_sellerItemOrder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rec_sellerItemOrder.setHasFixedSize(true);
        rec_sellerItemOrder.setAdapter(new SellerItemOrderAdapter(this, mlistModelsArray));

        //add static data into List array list
        mInvoiceModelsArray.add(new InvoiceListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));
        mInvoiceModelsArray.add(new InvoiceListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));

        rec_sellerInvoice.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rec_sellerInvoice.setHasFixedSize(true);
        rec_sellerInvoice.setAdapter(new SellerInvoiceAdapter(this, mInvoiceModelsArray));
    }

    private void ShowAssignDeliveryBoyPopup() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.alert_for_all_delivery_boy_list);
        TextView txtdoctorName = dialog.findViewById(R.id.txtDeliveryBoy);
        SearchableSpinner mSpinner = dialog.findViewById(R.id.spinner_all_delivery_boylist);

        mItemOrder = new ArrayAdapter<String>(mContext, R.layout.spinner_textview_medium, getResources().getStringArray(R.array.deliveryBoy));
        mSpinner.setAdapter(mItemOrder);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                //mGoalName = adapter.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ((Button) dialog.findViewById(R.id.btnSubmit))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //call api
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

    public class ListModel {
        int image;
        String orderId;

        public ListModel(int image, String orderId) {
            this.image = image;
            this.orderId = orderId;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }

    public class InvoiceListModel {
        int image;
        String orderId;

        public InvoiceListModel(int image, String orderId) {
            this.image = image;
            this.orderId = orderId;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }

    @OnClick({R.id.relDeliveryBoyList, R.id.btnCreateInvoice, R.id.btnSendEmail, R.id.btnCancelOrder, R.id.btnPrints,
            R.id.linearItemOrdered, R.id.linearInvoice, R.id.btnOrderItem, R.id.btnInvoice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relDeliveryBoyList:
                ShowAssignDeliveryBoyPopup();
                break;
            case R.id.btnCreateInvoice:
                break;
            case R.id.btnSendEmail:
                break;
            case R.id.btnCancelOrder:
                break;
            case R.id.btnPrints:
                break;
            case R.id.btnOrderItem:
                linearItemOrdered.setVisibility(View.VISIBLE);
                linearInvoice.setVisibility(View.GONE);
                break;
            case R.id.btnInvoice:
                linearInvoice.setVisibility(View.VISIBLE);
                linearItemOrdered.setVisibility(View.GONE);
                break;
        }
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackButton() {
        finish();
    }
}