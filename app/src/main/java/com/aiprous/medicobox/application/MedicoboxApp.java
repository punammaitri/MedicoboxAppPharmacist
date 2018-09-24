package com.aiprous.medicobox.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class MedicoboxApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
