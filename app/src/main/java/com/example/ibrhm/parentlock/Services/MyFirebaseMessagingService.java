package com.example.ibrhm.parentlock.Services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.example.ibrhm.parentlock.Database.DbOperations;
import com.example.ibrhm.parentlock.Database.MessageDB;
import com.example.ibrhm.parentlock.R;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by ibrhm on 6.03.2017.
 */

public class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
   Intent intent;
   public String title;
    MessageDB messageDB;
    DbOperations operations;
    @Override
    public void onCreate() {
        super.onCreate();
        messageDB =new MessageDB(MyFirebaseMessagingService.this);
        operations = new DbOperations();
       // Bundle extras = new Bundle();
       // extras.putString("name",remoteMessage.getNotification().getTitle());
        Intent intent = new Intent();
       // intent.putExtras(extras);
        intent.setClass(MyFirebaseMessagingService.this, FirstService.class);
        startActivity(intent);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {

        title = remoteMessage.getData().get("notificationRequests");
        try {
          Cursor cursor = operations.getRegister(messageDB);
            SQLiteDatabase db = messageDB.getWritableDatabase();
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex("id"));
                db.delete("command","id" + "=" +id, null);
            }
             operations.register(remoteMessage.getNotification().getTitle(), messageDB);
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"dbException::"+e,Toast.LENGTH_LONG).show();
        }
 //       showNotification(title);
    }






    private void showNotification(String message) {

        Intent i = new Intent(this,FirstService.class); // Bildirime basıldığında hangi aktiviteye gidilecekse
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setAutoCancel(true) // Kullanıcı bildirime girdiğinde otomatik olarak silinsin. False derseniz bildirim kalıcı olur.
                .setContentTitle("FCM Test") // Bildirim başlığı
                .setContentText(message) // Bildirim mesajı
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark) // Bildirim simgesi
                .setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(0,builder.build());
    }
}