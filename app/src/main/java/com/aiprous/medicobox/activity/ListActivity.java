package com.aiprous.medicobox.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aiprous.medicobox.adapter.ListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import medicobox.aiprous.com.medicobox.R;


public class ListActivity extends AppCompatActivity {

   // @BindView(R.id.rc_medicine_list)
    RecyclerView rc_medicine_list;
    ArrayList<ListActivity.ListModel> mlistModelsArray=new ArrayList<>();
    private Context mContext=this;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        rc_medicine_list=(RecyclerView)findViewById(R.id.rc_medicine_list);

         //add static data into array list
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage,"ABC","Bottle of 60 tablet","150","30%","135"));
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage,"ABC","Bottle of 60 tablet","150","30%","135"));
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage,"ABC","Bottle of 60 tablet","150","30%","135"));
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage,"ABC","Bottle of 60 tablet","150","30%","135"));
        mlistModelsArray.add(new ListModel(R.drawable.ic_menu_manage,"ABC","Bottle of 60 tablet","150","30%","135"));


        layoutManager = new LinearLayoutManager(mContext);
        rc_medicine_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc_medicine_list.setHasFixedSize(true);
        rc_medicine_list.setAdapter(new ListAdapter(mContext, mlistModelsArray));
    }

    public class ListModel{
        int image;
        String medicineName;
        String value;
        String mrp;
        String discount;
        String price;

        public ListModel(int image, String medicineName, String value, String mrp, String discount, String price) {
            this.image = image;
            this.medicineName = medicineName;
            this.value = value;
            this.mrp = mrp;
            this.discount = discount;
            this.price = price;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getMedicineName() {
            return medicineName;
        }

        public void setMedicineName(String medicineName) {
            this.medicineName = medicineName;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getMrp() {
            return mrp;
        }

        public void setMrp(String mrp) {
            this.mrp = mrp;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
