package com.example.ibrhm.parentlock.Services;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrhm.parentlock.Books.Book;
import com.example.ibrhm.parentlock.Database.DbOperations;
import com.example.ibrhm.parentlock.Database.MessageDB;
import com.example.ibrhm.parentlock.GamePackage.GameClass;
import com.example.ibrhm.parentlock.GamePackage.LogicGameClass;
import com.example.ibrhm.parentlock.Language.LanguageClass;
import com.example.ibrhm.parentlock.Locked.LockedClass;
import com.example.ibrhm.parentlock.Questions.QuestionClass;
import com.example.ibrhm.parentlock.Voice.VoiceClass;

/**
 * Created by ibrhm on 11.03.2017.
 */

public class FirstService extends Activity {


    Bundle extras;
    TextView textView;
    DbOperations operations;
    MessageDB messageDB;
    String message ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.fistservice);
        // textView = (TextView)findViewById(R.id.textView);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        messageDB = new MessageDB(FirstService.this);
        operations = new DbOperations();
        Intent intent = new Intent();
        String e1 =null;

        try {
            Cursor cursor = operations.getRegister(messageDB);
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex("id"));
                message = cursor.getString((cursor.getColumnIndex("message")));

            }

           if(message != null) {
               int replecement = Integer.parseInt(message);
               if (replecement<8) {
                   intent.setClass(FirstService.this, Book.class);
                   startActivity(intent);
               } else if (replecement<22) {
                   intent.setClass(FirstService.this, QuestionClass.class);
                   startActivity(intent);

               } else if (replecement ==22) {
                   intent.setClass(FirstService.this, GameClass.class);
                   startActivity(intent);

               }  else if (replecement ==23) {
                   intent.setClass(FirstService.this, LanguageClass.class);
                   startActivity(intent);

               } else if (replecement ==24) {
                   intent.setClass(FirstService.this, LogicGameClass.class);
                   startActivity(intent);

               }else if (replecement<32) {
                  FirstService.this.startService(new Intent(FirstService.this.getApplicationContext(), VoiceClass.class));
               }else if (replecement<38) {
                   intent.setClass(FirstService.this, LockedClass.class);
                   startActivity(intent);

               }
           }

        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"dbReadException::"+e,Toast.LENGTH_LONG).show();
        }
    }
}
