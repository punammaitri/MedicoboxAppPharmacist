package com.aiprous.medicoboxpharmacist.deliveryboy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.application.MedicoboxApp;
import com.aiprous.medicoboxpharmacist.model.ListOfDeliveryBoyModel;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.medicoboxpharmacist.utils.APIConstant.Authorization;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.BEARER;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.DELIVERY_BOY_LISTING;

public class ListOfDeliveryBoyActivity extends AppCompatActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;
    @BindView(R.id.rc_medicine_list)
    RecyclerView rc_medicine_list;
    ArrayList<ListOfDeliveryBoyModel> mDeliveryBoyModels = new ArrayList<ListOfDeliveryBoyModel>();
    private Context mContext = this;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_delivery_boy);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        txtTitle.setText("Delivery Boy List");
        rlayout_cart.setVisibility(View.GONE);

        //Change status bar color
        BaseActivity baseActivity = new BaseActivity();
        baseActivity.changeStatusBarColor(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        GetListOfDeliveryBoy();
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackPressSDescription() {
        finish();
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
                                for (int i = 0; i < entries.size(); i++) {
                                    String id = ((JsonObject) entries.get(i)).get("id").getAsString();
                                    String name = ((JsonObject) entries.get(i)).get("name").getAsString();

                                    ListOfDeliveryBoyModel model = new ListOfDeliveryBoyModel(id, name);
                                    model.setId(id);
                                    model.setName(name);
                                    mDeliveryBoyModels.add(model);
                                }
                            }
                            layoutManager = new LinearLayoutManager(mContext);
                            rc_medicine_list.setLayoutManager(new LinearLayoutManager(ListOfDeliveryBoyActivity.this, LinearLayoutManager.VERTICAL, false));
                            rc_medicine_list.setHasFixedSize(true);
                            rc_medicine_list.setAdapter(new ListOfDeliveryBoyAdapter(mContext, mDeliveryBoyModels));
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
}