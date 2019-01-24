package com.aiprous.medicoboxpharmacist.pharmacist.dashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aiprous.medicoboxpharmacist.MainActivity;
import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.application.MedicoboxApp;
import com.aiprous.medicoboxpharmacist.deliveryboy.ListOfDeliveryBoyActivity;
import com.aiprous.medicoboxpharmacist.deliveryboy.ListOfDeliveryBoyAdapter;
import com.aiprous.medicoboxpharmacist.designpattern.SingletonOrderStatus;
import com.aiprous.medicoboxpharmacist.model.AllOrderModel;
import com.aiprous.medicoboxpharmacist.model.ListOfDeliveryBoyModel;
import com.aiprous.medicoboxpharmacist.pharmacist.sellerorder.SellerOrderTabActivity;
import com.aiprous.medicoboxpharmacist.utils.APIConstant;
import com.aiprous.medicoboxpharmacist.utils.CustomProgressDialog;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
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
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.DELIVERY_BOY_LISTING;
import static com.aiprous.medicoboxpharmacist.utils.APIConstant.ORDER;

public class DashboardFragment extends Fragment {

    @BindView(R.id.rec_dashboard)
    RecyclerView rec_dashboard;
    @BindView(R.id.chart)
    BarChart mChart;

    ArrayList<SubListModel> mSubListModelsArray = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.linearLatestOrder)
    LinearLayout linearLatestOrder;
    private MainActivity mainActivity;

    public ArrayList<AllOrderModel.Canceled> mCanceledArray = new ArrayList<>();
    public ArrayList<AllOrderModel.Completed> mCompletedArray = new ArrayList<>();
    public ArrayList<AllOrderModel.Pending> mPendingArray = new ArrayList<>();
    public ArrayList<AllOrderModel.Processing> mProcessingArray = new ArrayList<>();

    SingletonOrderStatus lsingletonOrderData = SingletonOrderStatus.getGsonInstance();

    private OnFragmentInteractionListener mListener;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public DashboardFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {

        //add static data into Sub List array list
        mSubListModelsArray.add(new SubListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));
        mSubListModelsArray.add(new SubListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));
        mSubListModelsArray.add(new SubListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));

        layoutManager = new LinearLayoutManager(getActivity());
        rec_dashboard.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rec_dashboard.setHasFixedSize(true);
        rec_dashboard.setAdapter(new DashboardAdapter(getActivity(), mSubListModelsArray));

        BarData data = new BarData(getXAxisValues(), getDataSet());
        mChart.setData(data);

        mChart.setDescription("");
        mChart.animateXY(2000, 2000);
        mChart.getXAxis().setEnabled(true);
        mChart.setDrawValueAboveBar(false);
        mChart.getAxisLeft().setEnabled(false);
        mChart.getAxisRight().setEnabled(false);
        mChart.getAxisLeft().setDrawGridLines(false);

        //for X axis
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);

        XAxis xLabels = mChart.getXAxis();
        xLabels.setTextColor(R.color.colorlightlightlightGray);

        //for Y axis
        YAxis yAxis = mChart.getAxisLeft();
        yAxis.setDrawGridLines(false);
        yAxis.setDrawAxisLine(false);

        mChart.setDrawGridBackground(false);

        mChart.getLegend().setEnabled(false);
        mChart.invalidate();

    }

    @Override
    public void onResume() {
        super.onResume();
        GetAllOrder();
    }

    private void GetAllOrder() {

        CustomProgressDialog.getInstance().showDialog(getActivity(), "", APIConstant.PROGRESS_TYPE);
        AndroidNetworking.get(ORDER)
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

                        JsonObject entries = responseObject.get("order_data").getAsJsonObject();
                        JsonArray arrayProcessing = entries.get("processing").getAsJsonArray();
                        JsonArray arrayPending = entries.get("pending").getAsJsonArray();
                        JsonArray arrayCanceled = entries.get("canceled").getAsJsonArray();
                        JsonArray arrayCompleted = entries.get("completed").getAsJsonArray();

                        if (status.equals("success")) {

                            if (!(arrayProcessing.size() == 0)) {
                                mProcessingArray.clear();
                                for (int i = 0; i < arrayProcessing.size(); i++) {
                                    String entity_id = ((JsonObject) arrayProcessing.get(i)).get("entity_id").getAsString();
                                    String customer_firstname = ((JsonObject) arrayProcessing.get(i)).get("customer_firstname").getAsString();
                                    String customer_lastname = ((JsonObject) arrayProcessing.get(i)).get("customer_lastname").getAsString();
                                    String mStatus = ((JsonObject) arrayProcessing.get(i)).get("status").getAsString();
                                    String grand_total = ((JsonObject) arrayProcessing.get(i)).get("grand_total").getAsString();

                                    AllOrderModel.Processing model = new AllOrderModel.Processing(customer_lastname, customer_firstname, mStatus, entity_id, grand_total);
                                    model.setCustomerLastname(customer_lastname);
                                    model.setCustomerFirstname(customer_firstname);
                                    model.setStatus(mStatus);
                                    model.setEntityId(entity_id);
                                    model.setGrandTotal(grand_total);
                                    mProcessingArray.add(model);
                                }
                                lsingletonOrderData.mProcessingArray = mProcessingArray;
                            }

                            if (!(arrayPending.size() == 0)) {
                                mPendingArray.clear();
                                for (int i = 0; i < arrayPending.size(); i++) {
                                    String entity_id = ((JsonObject) arrayPending.get(i)).get("entity_id").getAsString();
                                    String customer_firstname = ((JsonObject) arrayPending.get(i)).get("customer_firstname").getAsString();
                                    String customer_lastname = ((JsonObject) arrayPending.get(i)).get("customer_lastname").getAsString();
                                    String mStatus = ((JsonObject) arrayPending.get(i)).get("status").getAsString();
                                    String grand_total = ((JsonObject) arrayPending.get(i)).get("grand_total").getAsString();

                                    AllOrderModel.Pending model = new AllOrderModel.Pending(customer_lastname, customer_firstname, mStatus, entity_id, grand_total);
                                    model.setCustomerLastname(customer_lastname);
                                    model.setCustomerFirstname(customer_firstname);
                                    model.setStatus(mStatus);
                                    model.setEntityId(entity_id);
                                    model.setGrandTotal(grand_total);
                                    mPendingArray.add(model);
                                }
                                lsingletonOrderData.mPendingArray = mPendingArray;
                            }

                            if (!(arrayCompleted.size() == 0)) {
                                mCompletedArray.clear();
                                for (int i = 0; i < arrayCompleted.size(); i++) {
                                    String entity_id = ((JsonObject) arrayCompleted.get(i)).get("entity_id").getAsString();
                                    String customer_firstname = ((JsonObject) arrayCompleted.get(i)).get("customer_firstname").getAsString();
                                    String customer_lastname = ((JsonObject) arrayCompleted.get(i)).get("customer_lastname").getAsString();
                                    String mStatus = ((JsonObject) arrayCompleted.get(i)).get("status").getAsString();
                                    String grand_total = ((JsonObject) arrayCompleted.get(i)).get("grand_total").getAsString();

                                    AllOrderModel.Completed model = new AllOrderModel.Completed(customer_lastname, customer_firstname, mStatus, entity_id, grand_total);
                                    model.setCustomerLastname(customer_lastname);
                                    model.setCustomerFirstname(customer_firstname);
                                    model.setStatus(mStatus);
                                    model.setEntityId(entity_id);
                                    model.setGrandTotal(grand_total);
                                    mCompletedArray.add(model);
                                }
                                lsingletonOrderData.mCompletedArray = mCompletedArray;
                            }

                            if (!(arrayCanceled.size() == 0)) {
                                mCanceledArray.clear();
                                for (int i = 0; i < arrayCanceled.size(); i++) {
                                    String entity_id = ((JsonObject) arrayCanceled.get(i)).get("entity_id").getAsString();
                                    String customer_firstname = ((JsonObject) arrayCanceled.get(i)).get("customer_firstname").getAsString();
                                    String customer_lastname = ((JsonObject) arrayCanceled.get(i)).get("customer_lastname").getAsString();
                                    String mStatus = ((JsonObject) arrayCanceled.get(i)).get("status").getAsString();
                                    String grand_total = ((JsonObject) arrayCanceled.get(i)).get("grand_total").getAsString();


                                    AllOrderModel.Canceled model = new AllOrderModel.Canceled(customer_lastname, customer_firstname, mStatus, entity_id, grand_total);
                                    model.setCustomerLastname(customer_lastname);
                                    model.setCustomerFirstname(customer_firstname);
                                    model.setStatus(mStatus);
                                    model.setEntityId(entity_id);
                                    model.setGrandTotal(grand_total);
                                    mCanceledArray.add(model);
                                }
                                lsingletonOrderData.mCanceledArray = mCanceledArray;
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

    @OnClick(R.id.linearLatestOrder)
    public void onViewClicked() {

        startActivity(new Intent(getActivity(), SellerOrderTabActivity.class));
    }

    public class SubListModel {
        int image;
        String product_name;

        public SubListModel(int image, String product_name) {
            this.image = image;
            this.product_name = product_name;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void onFragmentTrans(Fragment framgent) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_home, framgent).commit();
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(90.0f, 0);
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(50.0f, 1);
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(80.0f, 2);
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(70.0f, 3);
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(50.0f, 4);
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(85.0f, 5);
        valueSet1.add(v1e6);
        BarEntry v1e7 = new BarEntry(30.0f, 6);
        valueSet1.add(v1e7);

        BarDataSet barDataSet2 = new BarDataSet(valueSet1, "");
        barDataSet2.setColor(Color.rgb(31, 44, 76));
        barDataSet2.setDrawValues(false);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("MON");
        xAxis.add("TUE");
        xAxis.add("WED");
        xAxis.add("THU");
        xAxis.add("FRI");
        xAxis.add("SAT");
        xAxis.add("SUN");
        return xAxis;
    }


}