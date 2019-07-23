package com.anjukakoralage.hondapromo.Utils;

import android.graphics.Color;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

/**
 * Created by anjukakoralage on 18,July,2019
 */
public class NotificationUtil {

    public static void showSnakbarTypeOne(View rootView, String mMessage, int duration) {
        Snackbar
                .make(rootView, mMessage, duration)
                .show();
    }
}
