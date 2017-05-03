package com.example.ibrhm.parentlock.Language;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.ibrhm.parentlock.R;

/**
 * Created by ibrhm on 3.04.2017.
 */

public class LanguageClass extends Activity {
    ImageView image,image1,image2,image3,image4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english_main);
        operations();

    }
 public void operations()
 {
     image = (ImageView)findViewById(R.id.image);
     image1 = (ImageView)findViewById(R.id.image1);
     image2 = (ImageView)findViewById(R.id.image2);
     image3 = (ImageView)findViewById(R.id.image3);
     image4 = (ImageView)findViewById(R.id.image4);
    image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String string = "My Daily Routine";
            Intent i = new Intent(getApplicationContext(), StudyLanguage.class);
            i.putExtra("send_string",string);
            startActivity(i);

        }
    });
     image1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });
     image2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });
     image3.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });
     image4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });
 }
}

