package com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.activity.LoginActivity;
import com.aiprous.medicoboxpharmacist.application.MedicoboxApp;
import com.aiprous.medicoboxpharmacist.deliveryboy.ListOfDeliveryBoyActivity;
import com.aiprous.medicoboxpharmacist.deliveryboy.ListOfDeliveryBoyAdapter;
import com.aiprous.medicoboxpharmacist.model.ListOfDeliveryBoyModel;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.invoice.SellerInvoiceAdapter;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.itemorder.SellerItemOrderAdapter;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.aiprous.medicoboxpharmacist.utils.SearchableSpinner;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.APIConstant.ASSIGN_DELIVERY_BOY;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.Authorization;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.BEARER;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.DELIVERY_BOY_LISTING;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.GET_ORDER_INVOICE;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.ORDER_INVOICE;
import static com.aiprous.medicoboxpharmacist.utils.BaseActivity.isNetworkAvailable;

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
    ArrayAdapter<ListOfDeliveryBoyModel> mItemOrder;
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

    @BindView(R.id.txtInvoiceId)
    TextView txtInvoiceId;
    @BindView(R.id.txtDate)
    TextView txtDate;
    @BindView(R.id.txtOrder_id)
    TextView txtOrder_id;

    private Context mContext = this;
    ArrayList<ListOfDeliveryBoyModel> mDeliveryBoyModels = new ArrayList<ListOfDeliveryBoyModel>();
    ArrayList<ListOfDeliveryBoyModel> mNewDeliveryBoyModels = new ArrayList<ListOfDeliveryBoyModel>();
    private String mGetDeliveryBoyId;
    private String mGetId;
    private String mGetName;
    private String getId;

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
        final SearchableSpinner mSpinner = dialog.findViewById(R.id.spinner_all_delivery_boylist);

        /*mItemOrder = new ArrayAdapter<ListOfDeliveryBoyModel>(mContext, R.layout.spinner_textview_medium, getResources().getStringArray(R.array.deliveryBoy));*/


        mItemOrder = new ArrayAdapter<ListOfDeliveryBoyModel>(mContext, R.layout.spinner_textview_medium, mDeliveryBoyModels);
        mSpinner.setAdapter(mItemOrder);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (!(mDeliveryBoyModels.size() == 0)) {
                    mGetId = mDeliveryBoyModels.get(position).getId();
                    mGetName = mDeliveryBoyModels.get(position).getName();
                }
                Log.e("delivery_boy_id", "" + mGetId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ((Button) dialog.findViewById(R.id.btnSubmit))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mSpinner.getSelectedItem().equals("Select Delivery Boy")) {
                            Toast.makeText(mContext, "Please select delivery boy", Toast.LENGTH_SHORT).show();
                        } else {
                            if (!isNetworkAvailable(SellerOrderDetailActivity.this)) {
                                CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                            } else {

                                JSONObject jsonObject = new JSONObject();
                                try {
                                    jsonObject.put("order_id", getId);
                                    jsonObject.put("delivery_boy_id", mGetId);
                                    Log.e("data", "" + jsonObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                CallAPIForAssignDeliveryBoy(jsonObject);
                            }
                            dialog.dismiss();
                        }
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

    private void CallAPIForAssignDeliveryBoy(JSONObject jsonObject) {
        CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
        AndroidNetworking.post(ASSIGN_DELIVERY_BOY)
                .addJSONObjectBody(jsonObject)
                .addHeaders(Authorization, BEARER + MedicoboxApp.onGetBearer())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            // do anything with response
                            String message = String.valueOf(response.get("message"));
                            Toast.makeText(mContext, "" + message, Toast.LENGTH_SHORT).show();
                            CustomProgressDialog.getInstance().dismissDialog();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
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
                if (!isNetworkAvailable(SellerOrderDetailActivity.this)) {
                    CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                } else {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("order_id", getId);
                        Log.e("data", "" + jsonObject);
                        CallCreateInvoiceAPI(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
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

                if (!isNetworkAvailable(SellerOrderDetailActivity.this)) {
                    CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
                } else {
                    GetOrderInvoice();
                }
                break;
        }
    }

    private void CallCreateInvoiceAPI(JSONObject jsonObject) {
        CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
        AndroidNetworking.post(ORDER_INVOICE)
                .addJSONObjectBody(jsonObject)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                    /*    JsonObject getAllResponse = (JsonObject) new JsonParser().parse(response.toString());
                        JsonObject responseObject = getAllResponse.get("response").getAsJsonObject();
                        String status = responseObject.get("status").getAsString();*/
                        CustomProgressDialog.getInstance().dismissDialog();
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackButton() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!isNetworkAvailable(SellerOrderDetailActivity.this)) {
            CustomProgressDialog.getInstance().showDialog(mContext, mContext.getResources().getString(R.string.check_your_network), APIConstant.ERROR_TYPE);
        } else {
            GetListOfDeliveryBoy();
        }

        if (getIntent().getStringExtra("id") != null) {
            getId = getIntent().getStringExtra("id");
        }
    }

    private void GetOrderInvoice() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("order_id", getId);
            Log.e("data", "" + jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);

        AndroidNetworking.post(GET_ORDER_INVOICE)
                .addJSONObjectBody(jsonObject)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response

                        JsonObject getAllResponse = (JsonObject) new JsonParser().parse(response.toString());
                        JsonObject responseObject = getAllResponse.get("response").getAsJsonObject();
                        String status = responseObject.get("status").getAsString();

                        if (status.equals("success")) {
                            JsonArray entries = responseObject.get("data").getAsJsonArray();
                            if (!(entries.size() == 0)) {
                                String order_id = ((JsonObject) entries.get(0)).get("order_id").getAsString();
                                String store_id = ((JsonObject) entries.get(0)).get("store_id").getAsString();
                                String created_at = ((JsonObject) entries.get(0)).get("created_at").getAsString();
                                String increment_id = ((JsonObject) entries.get(0)).get("increment_id").getAsString();

                                txtInvoiceId.setText("Invoice #" + increment_id);
                                txtDate.setText("Date: " + created_at);
                                txtOrder_id.setText("Order #" + order_id);
                            }
                            CustomProgressDialog.getInstance().dismissDialog();
                        } else {
                            CustomProgressDialog.getInstance().dismissDialog();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });


    }

    private void GetListOfDeliveryBoy() {
        CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
        AndroidNetworking.post(DELIVERY_BOY_LISTING)
                .addHeaders(Authorization, BEARER + MedicoboxApp.onGetBearer())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response

                        JsonObject getAllResponse = (JsonObject) new JsonParser().parse(response.toString());
                        JsonObject responseObject = getAllResponse.get("response").getAsJsonObject();
                        String status = responseObject.get("status").getAsString();
                        if (status.equals("success")) {
                            JsonArray entries = responseObject.get("data").getAsJsonArray();
                            if (entries != null) {
                                mDeliveryBoyModels.clear();

                                ListOfDeliveryBoyModel data = new ListOfDeliveryBoyModel("Select Delivery Boy", "");
                                data.setName("Select Delivery Boy");
                                data.setId("");
                                mDeliveryBoyModels.add(data);

                                for (int i = 0; i < entries.size(); i++) {
                                    String id = ((JsonObject) entries.get(i)).get("id").getAsString();
                                    String name = ((JsonObject) entries.get(i)).get("name").getAsString();

                                    ListOfDeliveryBoyModel model = new ListOfDeliveryBoyModel(id, name);
                                    model.setId(id);
                                    model.setName(name);
                                    mDeliveryBoyModels.add(model);
                                }
                            }

                            CustomProgressDialog.getInstance().dismissDialog();
                        } else {
                            CustomProgressDialog.getInstance().dismissDialog();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        CustomProgressDialog.getInstance().dismissDialog();
                        Log.e("Error", "onError errorCode : " + error.getErrorCode());
                        Log.e("Error", "onError errorBody : " + error.getErrorBody());
                        Log.e("Error", "onError errorDetail : " + error.getErrorDetail());
                    }
                });
    }
}