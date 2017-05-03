package com.example.ibrhm.parentlock.Services;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by ibrhm on 6.03.2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        registerToken(token);
        FirebaseMessaging.getInstance()
                .subscribeToTopic("FRIENDLY_ENGAGE_TOPIC");


    }

    private void registerToken(String token){

    }}