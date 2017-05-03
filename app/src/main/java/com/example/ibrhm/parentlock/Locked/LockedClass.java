package com.example.ibrhm.parentlock.Locked;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ibrhm on 12.04.2017.
 */

public class LockedClass extends Activity {

    Timer timer;
    MyTimerTask myTimerTask;
    int x =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new CountDownTimer(60000, 1000) {
            @Override
            //OnTick metodu geri sayım süresince yapılacak değişiklikler
            public void onTick(long millisUntilFinished) {


            }

            @Override
            //süre bittiğinde yapılacaklar
            public void onFinish() {
                x++;

            }
        }.start();
    } @Override
    protected void onResume() {
        super.onResume();

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    protected void onPause()
    {
        if (timer == null) {
            myTimerTask = new MyTimerTask();
            timer = new Timer();
            timer.schedule(myTimerTask, 10, 10);
        }

        super.onPause();
    }

    private void bringApplicationToFront()
    {
        if(x==0) {  KeyguardManager myKeyManager = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);
            if( myKeyManager.inKeyguardRestrictedInputMode())
                return;

            Log.d("TAG", "====Bringging Application to Front====");


            Intent notificationIntent = new Intent(this, LockedClass.class);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            try
            {
                pendingIntent.send();
            }
            catch (PendingIntent.CanceledException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        // do not call super onBackPressed.
    }

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            bringApplicationToFront();
        }
    }

}
