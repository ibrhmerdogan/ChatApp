package com.example.ibrhm.parentlock.Language;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ibrhm.parentlock.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrhm on 3.04.2017.
 */

public class StudyLanguage extends Activity {
    TextView textView;
    ImageView imageView,imageView1,imageView2;
    int i = 0;
    List<Integer> list = new ArrayList<>();
    GetPictureId getPictureId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studyenglish_view);

        textView  = (TextView)findViewById(R.id.txt);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        getPictureId = new GetPictureId();
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("send_string");
        textView.setText(value.toString());
        list = getPictureId.getId();
        imageView.setImageResource(list.get(i));

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((i+1)<list.size())
                {
                    i++;
                    imageView.setImageResource(list.get(i));

                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0)
                {
                    i--;
                imageView.setImageResource(list.get(i));
                }
            }
        });

    }
}
