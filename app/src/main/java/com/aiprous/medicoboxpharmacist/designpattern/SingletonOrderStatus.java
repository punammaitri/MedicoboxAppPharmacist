package com.aiprous.medicoboxpharmacist.designpattern;

import com.aiprous.medicoboxpharmacist.model.AllOrderModel;

import java.util.ArrayList;

public class SingletonOrderStatus {

    private static SingletonOrderStatus gsonInstance;

    public ArrayList<AllOrderModel.Canceled> mCanceledArray = new ArrayList<>();
    public ArrayList<AllOrderModel.Completed> mCompletedArray = new ArrayList<>();
    public ArrayList<AllOrderModel.Pending> mPendingArray = new ArrayList<>();
    public ArrayList<AllOrderModel.Processing> mProcessingArray = new ArrayList<>();


    public static SingletonOrderStatus getGsonInstance() {

        if (gsonInstance == null) {
            gsonInstance = new SingletonOrderStatus();
        }
        return gsonInstance;
    }
}
