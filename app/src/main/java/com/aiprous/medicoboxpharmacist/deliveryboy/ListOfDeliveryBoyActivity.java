package com.aiprous.medicoboxpharmacist.deliveryboy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aiprous.medicoboxpharmacist.R;
import com.aiprous.medicoboxpharmacist.utils.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListOfDeliveryBoyActivity extends AppCompatActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.rlayout_cart)
    RelativeLayout rlayout_cart;
    @BindView(R.id.rc_medicine_list)
    RecyclerView rc_medicine_list;

    ArrayList<ListOfDeliveryBoyActivity.ListModel> mlistModelsArray = new ArrayList<>();
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

        //add static data into array list
        mlistModelsArray.add(new ListModel(R.drawable.user, "John Smith"));
        mlistModelsArray.add(new ListModel(R.drawable.user, "John Smith"));
        mlistModelsArray.add(new ListModel(R.drawable.user, "John Smith"));
        mlistModelsArray.add(new ListModel(R.drawable.user, "John Smith"));

        layoutManager = new LinearLayoutManager(mContext);
        rc_medicine_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc_medicine_list.setHasFixedSize(true);
        rc_medicine_list.setAdapter(new ListOfDeliveryBoyAdapter(mContext, mlistModelsArray));
    }

    @OnClick(R.id.rlayout_back_button)
    public void BackPressSDescription() {
        finish();
    }


    public class ListModel {
        int image;
        String deliveryBoyName;

        public ListModel(int image, String deliveryBoyName) {
            this.image = image;
            this.deliveryBoyName = deliveryBoyName;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getDeliveryBoyName() {
            return deliveryBoyName;
        }

        public void setDeliveryBoyName(String deliveryBoyName) {
            this.deliveryBoyName = deliveryBoyName;
        }
    }
}