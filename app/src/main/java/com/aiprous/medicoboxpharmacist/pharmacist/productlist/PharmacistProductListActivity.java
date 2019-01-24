package com.aiprous.medicoboxpharmacist.pharmacist.productlist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.application.MedicoboxApp;
import com.aiprous.medicoboxpharmacist.model.ProductListModel;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.APIConstant.Authorization;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.BEARER;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.PRODUCT_LIST;

public class PharmacistProductListActivity extends AppCompatActivity {

    @BindView(R.id.searchview_products)
    SearchView searchview_products;
    @BindView(R.id.rc_product_list)
    RecyclerView rc_product_list;
    @BindView(R.id.rlayout_back_button)
    RelativeLayout rlayout_back_button;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    private Context mContext = this;
    ArrayList<ProductListModel> mProductListModels = new ArrayList<ProductListModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_product_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        searchview_products.setFocusable(false);

        txtTitle.setText("Products");
        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        GetProductList();
    }

    private void GetProductList() {
        CustomProgressDialog.getInstance().showDialog(mContext, "", APIConstant.PROGRESS_TYPE);
        AndroidNetworking.get(PRODUCT_LIST)
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
                            JsonArray entries = responseObject.get("product_data").getAsJsonArray();
                            if (entries != null) {
                                mProductListModels.clear();
                                for (int i = 0; i < entries.size(); i++) {
                                    String entity_id = ((JsonObject) entries.get(i)).get("entity_id").getAsString();
                                    String attribute_set_id = ((JsonObject) entries.get(i)).get("attribute_set_id").getAsString();
                                    String type_id = ((JsonObject) entries.get(i)).get("type_id").getAsString();
                                    String sku = ((JsonObject) entries.get(i)).get("sku").getAsString();
                                    String has_options = ((JsonObject) entries.get(i)).get("has_options").getAsString();
                                    String required_options = ((JsonObject) entries.get(i)).get("required_options").getAsString();
                                    String qty = ((JsonObject) entries.get(i)).get("qty").getAsString();


                                    ProductListModel model = new ProductListModel(qty, required_options,has_options,sku,type_id,attribute_set_id,entity_id);
                                    model.setQty(qty);
                                    model.setRequiredOptions(required_options);
                                    model.setHasOptions(has_options);
                                    model.setSku(sku);
                                    model.setTypeId(type_id);
                                    model.setAttributeSetId(attribute_set_id);
                                    model.setEntityId(entity_id);
                                    mProductListModels.add(model);
                                }
                            }
                            rc_product_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
                            rc_product_list.setHasFixedSize(true);
                            rc_product_list.setAdapter(new PharmacistProductListAdapter(mContext, mProductListModels));
                            CustomProgressDialog.getInstance().dismissDialog();
                        }else {
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

    @OnClick(R.id.rlayout_back_button)
    public void BackPressSDescription() {
        finish();
    }
}