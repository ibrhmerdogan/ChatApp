package com.example.ibrhm.parentlock.Voice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by ibrhm on 4.04.2017.
 */

public class VoiceClass extends Service {


    AudioManager myAudioManager;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        myAudioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_SHOW_UI);
    }
}
/*RINGER_MODE_VIBRATE : Titreşim Mod

2 - RINGER_MODE_NORMAL : Normal Mod

3 - RINGER_MODE_SILENT : Sessiz Mod*/