package com.example.ibrhm.parentlock.Users;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ibrhm.parentlock.Services.FirstService;

/**
 * Created by ibrhm on 13.03.2017.
 */

public class MyReceiver extends BroadcastReceiver {
    private Bundle extras = null;
    Intent ıntent;
    @Override
    public void onReceive(Context context, Intent intent) {

        intent= new Intent(context,FirstService.class);


    }
}
