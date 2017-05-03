package com.example.ibrhm.parentlock.Users;

/**
 * Created by ibrhm on 2.03.2017.
 */

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.ibrhm.parentlock.Books.Book;
import com.example.ibrhm.parentlock.GamePackage.GameClass;
import com.example.ibrhm.parentlock.GamePackage.LogicGameClass;
import com.example.ibrhm.parentlock.Language.LanguageClass;
import com.example.ibrhm.parentlock.Questions.QuestionClass;
import com.example.ibrhm.parentlock.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;


public class UserList extends CustomActivity
{

    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1905;
    DatabaseReference database;
    Button btn,btn1,btn2,btn3,btn4;
    private ArrayList<User> uList;
    String mail = "ibrhmerdogan@gmail.com";
    public static User user;
     Bundle extras;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        if (!checkAndRequestPermissions()) {
            return;
        }
        database  = FirebaseDatabase.getInstance().getReference();
        btn = (Button)findViewById(R.id.btn);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        //extras = getIntent().getExtras();
       /// mail = extras.getString("NAME");
      // loadUserList();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserList.this, Book.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserList.this,LogicGameClass.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserList.this, QuestionClass.class));

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserList.this, LanguageClass.class));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserList.this, GameClass.class));
              //  UserList.this.startService(new Intent(UserList.this.getApplicationContext(), VoiceClass.class));

            }
        });

    }


    private void loadUserList()
    {
        final ProgressDialog dia = ProgressDialog.show(this, null,
                getString(R.string.alert_loading));
        database.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {dia.dismiss();
                long size  = dataSnapshot.getChildrenCount();
                if(size == 0) {
                    Toast.makeText(UserList.this,
                            R.string.msg_no_user_found,
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                uList = new ArrayList<User>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    User user = ds.getValue(User.class);
                      String a = user.getEmail();
                    String b = user.getId();
                    if(a.equals(mail))
                    {
                        FirebaseMessaging.getInstance()
                                .subscribeToTopic("user_" +b);

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    private class UserAdapter extends BaseAdapter
    {


        @Override
        public int getCount()
        {
            return uList.size();
        }


        @Override
        public User getItem(int arg0)
        {
            return uList.get(arg0);
        }


        @Override
        public long getItemId(int arg0)
        {
            return arg0;
        }


        @Override
        public View getView(int pos, View v, ViewGroup arg2)
        {

            return v;
        }

    }

    private boolean checkAndRequestPermissions() {
        int permissionINTERNET = ContextCompat.checkSelfPermission(this, android.Manifest.permission.MODIFY_AUDIO_SETTINGS);
        int permissionINTERNET1= ContextCompat.checkSelfPermission(this, Manifest.permission.VIBRATE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (permissionINTERNET != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.MODIFY_AUDIO_SETTINGS);
        } if (permissionINTERNET1 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.VIBRATE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
}
