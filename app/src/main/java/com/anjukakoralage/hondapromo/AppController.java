package com.anjukakoralage.hondapromo;

import android.app.Application;
import android.text.TextUtils;

import com.anjukakoralage.hondapromo.Utils.CPBroadcastReceiver;

/**
 * Created by anjukakoralage on 25,July,2019
 */
    public class AppController extends Application {
        public static final String TAG = AppController.class.getSimpleName();
        private static AppController mInstance;

        @Override
        public void onCreate() {
            super.onCreate();
            //Fabric.with(this, new Crashlytics());
            mInstance = this;
        }

        public static synchronized AppController getInstance() {
            return mInstance;
        }

        public void setConnectivityListener(CPBroadcastReceiver.ConnectivityReceiverListener listener) {
            CPBroadcastReceiver.connectivityReceiverListener = listener;
        }
    }
