package com.example.ibrhm.parentlock.GamePackage;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ibrhm.parentlock.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrhm on 22.03.2017.
 */

public class LogicGameClass extends Activity {

    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12;
    int p1,p2,p3,p4,p5,p6,p7,p8;
    int t=0;
    int backup[] = new int[2];
    RandomClass random;
    Button volumebtn;
    TextView name;
    int id[] = {0,0,0,0,0,0,0,0};
    int colorList[] = new int[12];
    int list[] = new int[12];
    int x;
    int backup1;
    List<ImageView> imageList = new ArrayList<>();
    List<String> getStringList = new ArrayList<>();
    int sayac = 0;
    Animation FabRanticlockwise,FabOpen,FabClose,FabRClockwise;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logic_game_view);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/fontawesome-webfont.ttf");
        name = (TextView)findViewById(R.id.textView2);
        volumebtn =  (Button) findViewById(R.id.btnvlm);
        volumebtn.setTypeface(custom_font);
        random = new RandomClass();
        list = random.randomFunctions(12);
        getDrawbleId();
        operations();
        getString();


    }

    public void comperativeId(int backUp)
    {
        backup[t] = backUp;
        t++;
        if(t==2)
        {
            if(colorList[list[backup[0]]] == colorList[list[backup[1]]])
            {
                imageList.get(backup[0]).startAnimation(FabRanticlockwise);
                imageList.get(backup[1]).startAnimation(FabRanticlockwise);
                name.setText("");
                name.setText(getStringList.get(list[backup[0]]));
                backup[0]=100;
                backup[1]=100;
                t=0;
            }
            else
                {
                    imageList.get(backup[0]).setImageResource(R.drawable.greyp);
                    imageList.get(backup[0]).setClickable(true);
                    backup[0] = backup[1];
                    backup[1]=100;
                    t=1;
                }
        }
    }


    public void operations()
    {

        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anima_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anima_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlickwise);
        imageView1 =  (ImageView)findViewById(R.id.image);
        imageList.add(imageView1);
        imageView2= (ImageView)findViewById(R.id.image1);
        imageList.add(imageView2);
        imageView3 = (ImageView)findViewById(R.id.image2);
        imageList.add(imageView3);
        imageView4 = (ImageView)findViewById(R.id.image3);
        imageList.add(imageView4);
        imageView5 = (ImageView)findViewById(R.id.image4);
        imageList.add(imageView5);
        imageView6 = (ImageView)findViewById(R.id.image5);
        imageList.add(imageView6);
        imageView7 = (ImageView)findViewById(R.id.image6);
        imageList.add(imageView7);
        imageView8 = (ImageView)findViewById(R.id.image7);
        imageList.add(imageView8);
        imageView9 = (ImageView)findViewById(R.id.roundedImageView);
        imageList.add(imageView9);
        imageView10 = (ImageView)findViewById(R.id.roundedImageView2);
        imageList.add(imageView10);
        imageView11 = (ImageView)findViewById(R.id.roundedImageView3);
        imageList.add(imageView11);
        imageView12 = (ImageView)findViewById(R.id.roundedImageView4);
        imageList.add(imageView12);
        imageList.get(0).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              imageList.get(0).setImageResource(colorList[list[0]]);
              backup1 = 0;
              imageList.get(0).setClickable(false);
              comperativeId(backup1);


          }
        });
        imageList.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(1).setImageResource(colorList[list[1]]);
                backup1 = 1;
                imageList.get(1).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(2).setImageResource(colorList[list[2]]);
                backup1 = 2;
                imageList.get(2).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(3).setImageResource(colorList[list[3]]);
                backup1 = 3;
                imageList.get(3).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(4).setImageResource(colorList[list[4]]);
                backup1 = 4;
                imageList.get(4).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(5).setImageResource(colorList[list[5]]);
                backup1 = 5;
                imageList.get(5).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(6).setImageResource(colorList[list[6]]);
                backup1 = 6;
                imageList.get(6).setClickable(false);
                comperativeId(backup1);
                }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(7).setImageResource(colorList[list[7]]);
                backup1 = 7;
                imageList.get(7).setClickable(false);
               comperativeId(backup1);
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(8).setImageResource(colorList[list[8]]);
                backup1 = 8;
                imageList.get(8).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(9).setImageResource(colorList[list[9]]);
                backup1 = 9;
                imageList.get(9).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(10).setImageResource(colorList[list[10]]);
                backup1 = 10;
                imageList.get(10).setClickable(false);
                comperativeId(backup1);
            }
        });
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageList.get(11).setImageResource(colorList[list[11]]);
                backup1 = 11;
                imageList.get(11).setClickable(false);
                comperativeId(backup1);
            }
        });


    }

    public void getDrawbleId()
    {

        p1= R.drawable.apple;
        colorList[0] = p1;
        p2= R.drawable.apple;
        colorList[1]=p2;
        p3= R.drawable.orenga;
        colorList[2]=p3;
        p4= R.drawable.orenga;
        colorList[3]=p4;
        p5= R.drawable.pear;
        colorList[4]=p5;
        p6= R.drawable.pear;
        colorList[5]=p6;
        p7=R.drawable.grape;
        colorList[6]=p7;
       p8= R.drawable.grape;
        colorList[7]=p8;
        colorList[8] = R.drawable.peach;
        colorList[9] = R.drawable.peach;
        colorList[10] = R.drawable.cherry;
        colorList[11] = R.drawable.cherry;
    }
    public void getString()
    {
        getStringList.add(getString(R.string.elma));
        getStringList.add(getString(R.string.elma));
        getStringList.add(getString(R.string.portakal));
        getStringList.add(getString(R.string.portakal));
        getStringList.add(getString(R.string.armut));
        getStringList.add(getString(R.string.armut));
        getStringList.add(getString(R.string.uzum));
        getStringList.add(getString(R.string.uzum));
        getStringList.add(getString(R.string.seftali));
        getStringList.add(getString(R.string.seftali));
        getStringList.add(getString(R.string.visne));
        getStringList.add(getString(R.string.visne));

    }
}
