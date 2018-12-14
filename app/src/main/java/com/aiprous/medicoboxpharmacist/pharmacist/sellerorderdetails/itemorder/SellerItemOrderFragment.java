package com.aiprous.medicoboxpharmacist.pharmacist.sellerorderdetails.itemorder;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SellerItemOrderFragment extends Fragment {

    @BindView(R.id.rec_sellerItemOrder)
    RecyclerView rec_sellerItemOrder;

    ArrayList<ListModel> mlistModelsArray = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    @BindView(R.id.relDeliveryBoyList)
    RelativeLayout relDeliveryBoyList;
    @BindView(R.id.btnCreateInvoice)
    Button btnCreateInvoice;
    @BindView(R.id.btnSendEmail)
    Button btnSendEmail;
    @BindView(R.id.btnCancelOrder)
    Button btnCancelOrder;
    @BindView(R.id.btnPrint)
    Button btnPrint;
    ArrayAdapter<String> mItemOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seller_item_order, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        //add static data into List array list
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage, "Horlicks Lite Badam Jar 450 gm"));

        layoutManager = new LinearLayoutManager(getActivity());
        rec_sellerItemOrder.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rec_sellerItemOrder.setHasFixedSize(true);
        //rec_sellerItemOrder.setAdapter(new SellerItemOrderAdapter(getActivity(), mlistModelsArray));
    }

    @OnClick({R.id.relDeliveryBoyList, R.id.btnCreateInvoice, R.id.btnSendEmail, R.id.btnCancelOrder, R.id.btnPrint})
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
            case R.id.btnPrint:
                break;
        }
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

    private void ShowAssignDeliveryBoyPopup() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.alert_for_all_delivery_boy_list);
        TextView txtdoctorName = dialog.findViewById(R.id.txtDeliveryBoy);
        Spinner mSpinner = dialog.findViewById(R.id.spinner_all_delivery_boylist);

        mItemOrder = new ArrayAdapter<String>(getActivity(), R.layout.spiner_add_user_item, getResources().getStringArray(R.array.deliveryBoy));
        mItemOrder.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
}