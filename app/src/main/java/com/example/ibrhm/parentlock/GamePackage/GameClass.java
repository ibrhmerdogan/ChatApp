package com.example.ibrhm.parentlock.GamePackage;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ibrhm.parentlock.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ibrhm on 19.03.2017.
 */

public class GameClass extends Activity  implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    RandomClass randomClass;
    TextView count,newGame;
    final MyCounter timer = new MyCounter(45000,1000);
    int replacement[] = {0,0,0,0,0,0,0};
    Animation FabRanticlockwise,FabOpen,FabClose,FabRClockwise;
    int list[] = new int[7];
    final String[] constraint = { "Language","Turkish","English"};
    int listColor1[] = new int[7];
    int listColor[] = new int[7];
    int list1[] = new int[6];
    int time=60000;
    boolean counter= false;
    Spinner spinner;
    int btnID[] ={R.id.btn,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btn10,
            R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14,R.id.btn15,R.id.btn16,R.id.btn17,R.id.btn18,R.id.btn19,R.id.btn20,
            R.id.btn21,R.id.btn22,R.id.btn23,R.id.btn24,R.id.btn25,R.id.btn26,R.id.btn27,R.id.btn28,R.id.btn29,R.id.btn30,
            R.id.btn31,R.id.btn32,R.id.btn33,R.id.btn34,R.id.btn35,R.id.btn36,R.id.btn37,R.id.btn38,R.id.btn39,R.id.btn40,R.id.btn41};
    List<Button> btnList= new ArrayList<>();
    @SuppressWarnings("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logic_game_include);
        operations();
       randomClass = new RandomClass();
        list = randomClass.randomFunctions(7);
        buttonAdlist();
        addColorId();
        timer.start();
        setColor();
        getColor();


    }

    @Override
    public void onClick(View v) {

        for(int i=0; i<btnID.length;i++) {
            if (v.getId() == btnID[i]) {
                list1 = randomClass.randomFunctions(6);
                Button btn = (Button)findViewById(v.getId());
                btn.startAnimation(FabRanticlockwise);
                v.setBackgroundColor(listColor[list1[i%6]]);
                if(i==0)
                {
                    listColor1[0] = listColor[list1[i%6]];
                    replacement[0]=0;
                }
                else  if(i==6)
                {
                    listColor1[1] = listColor[list1[i%6]];
                    replacement[1]=0;
                }else  if(i==12)
                {
                    listColor1[2] = listColor[list1[i%6]];
                    replacement[2]=0;
                }
                else  if(i==18)
                {
                    listColor1[3] = listColor[list1[i%6]];
                    replacement[3]=0;
                }else  if(i==24)
                {
                    listColor1[4] = listColor[list1[i%6]];
                    replacement[4]=0;
                }else  if(i==30)
                {
                    listColor1[5] = listColor[list1[i%6]];
                    replacement[5]=0;
                }else  if(i==36)
                {
                    listColor1[6] = listColor[list1[i%6]];
                    replacement[6]=0;
                }

            }

        }
        if(replacement[0]==0 && ((ColorDrawable)btnList.get(1).getBackground()).getColor()==listColor1[0] &&((ColorDrawable)btnList.get(2).getBackground()).getColor()==listColor1[0] &&
                ((ColorDrawable)btnList.get(3).getBackground()).getColor()==listColor1[0] &&((ColorDrawable)btnList.get(4).getBackground()).getColor()==listColor1[0] &&
                ((ColorDrawable)btnList.get(5).getBackground()).getColor()==listColor1[0] )
        {
            timer.cancel();
            timer.start();
            replacement[0]++;
        }
        if(replacement[1]==0 && ((ColorDrawable)btnList.get(7).getBackground()).getColor()==listColor1[1] &&((ColorDrawable)btnList.get(8).getBackground()).getColor()==listColor1[1] &&
                ((ColorDrawable)btnList.get(9).getBackground()).getColor()==listColor1[1] &&((ColorDrawable)btnList.get(10).getBackground()).getColor()==listColor1[1] &&
                ((ColorDrawable)btnList.get(11).getBackground()).getColor()==listColor1[1] )
        {
            timer.cancel();
            timer.start();
            replacement[1]++;
        }
        if(replacement[2]==0 && ((ColorDrawable)btnList.get(13).getBackground()).getColor()==listColor1[2] &&((ColorDrawable)btnList.get(14).getBackground()).getColor()==listColor1[2] &&
                ((ColorDrawable)btnList.get(15).getBackground()).getColor()==listColor1[2] &&((ColorDrawable)btnList.get(16).getBackground()).getColor()==listColor1[2] &&
                ((ColorDrawable)btnList.get(17).getBackground()).getColor()==listColor1[2] )
        {
            timer.cancel();
            timer.start();
            replacement[2]++;
        }
        if(replacement[3]==0 && ((ColorDrawable)btnList.get(19).getBackground()).getColor()==listColor1[3] &&((ColorDrawable)btnList.get(20).getBackground()).getColor()==listColor1[3] &&
                ((ColorDrawable)btnList.get(21).getBackground()).getColor()==listColor1[3] &&((ColorDrawable)btnList.get(22).getBackground()).getColor()==listColor1[3] &&
                ((ColorDrawable)btnList.get(23).getBackground()).getColor()==listColor1[3] )
        {
            timer.cancel();
            timer.start();
            replacement[3]++;
        }
        if(replacement[4]==0 && ((ColorDrawable)btnList.get(25).getBackground()).getColor()==listColor1[4] &&((ColorDrawable)btnList.get(26).getBackground()).getColor()==listColor1[4] &&
                ((ColorDrawable)btnList.get(27).getBackground()).getColor()==listColor1[4] &&((ColorDrawable)btnList.get(28).getBackground()).getColor()==listColor1[4] &&
                ((ColorDrawable)btnList.get(29).getBackground()).getColor()==listColor1[4] )
        {
            timer.cancel();
            timer.start();
            replacement[4]++;
        }

        if(replacement[5]==0 && ((ColorDrawable)btnList.get(31).getBackground()).getColor()==listColor1[5] &&((ColorDrawable)btnList.get(32).getBackground()).getColor()==listColor1[5] &&
                ((ColorDrawable)btnList.get(33).getBackground()).getColor()==listColor1[5] &&((ColorDrawable)btnList.get(34).getBackground()).getColor()==listColor1[5] &&
                ((ColorDrawable)btnList.get(35).getBackground()).getColor()==listColor1[5] )
        {
            timer.cancel();
            timer.start();
            replacement[5]++;
        }  if(replacement[6]==0 &&((ColorDrawable)btnList.get(37).getBackground()).getColor()==listColor1[6] &&((ColorDrawable)btnList.get(38).getBackground()).getColor()==listColor1[6] &&
                ((ColorDrawable)btnList.get(39).getBackground()).getColor()==listColor1[6] &&((ColorDrawable)btnList.get(40).getBackground()).getColor()==listColor1[6] &&
                ((ColorDrawable)btnList.get(41).getBackground()).getColor()==listColor1[6] )
        {
            timer.cancel();
            timer.start();
            replacement[6]++;
        }
        if(replacement[0]!=0 && replacement[1]!=0 &&  replacement[2]!=0  && replacement[3]!=0 &&  replacement[4]!=0 && replacement[5]!=0 && replacement[6]!=0)
            {
                newGame.setText("Kazandınız");
                newGame.startAnimation(FabOpen);
                newGame.setClickable(true);
            }



        //  Toast.makeText(getApplicationContext(),""+((ColorDrawable)btnList.get(0).getBackground()).getColor(),Toast.LENGTH_LONG).show();
    }

    public void buttonAdlist() {
        for (int i = 0; i < btnID.length; i++) {
            btnList.add((Button) findViewById(btnID[i]));
        }
    }
    public void operations()
    {
        count =(TextView)findViewById(R.id.count);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anima_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anima_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlickwise);
        newGame = (TextView)findViewById(R.id.yenioyun);
        spinner = (Spinner) findViewById(R.id.spinnerLang);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, constraint);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame.startAnimation(FabClose);
                timer.cancel();
                timer.start();
                setColor();
            }
        });

    }
    public void addColorId()
    {
        listColor[0] = Color.BLUE;
        listColor[1] = Color.BLACK;
        listColor[2] = Color.RED;
        listColor[3] = Color.YELLOW;
        listColor[4] = Color.GREEN;
        listColor[5] = Color.CYAN;
        listColor[6] = Color.GRAY;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void setColor()
    {
        for(int j=0 ; j<btnList.size(); j++) {
            list1 = randomClass.randomFunctions(6);
            for (int i = 0; i < 6; i++) {
                btnList.get(j).setBackgroundColor(listColor[list1[i]]);
            }
        }
    }
    public void getColor()
    {
        for(int i = 0; i<7; i++){
            if(((ColorDrawable)btnList.get(0).getBackground()).getColor() ==listColor[i])
            {
                listColor1[0] = listColor[i];
            }else if(((ColorDrawable)btnList.get(6).getBackground()).getColor() ==listColor[i])
            {
                listColor1[1] = listColor[i];
            }else  if(((ColorDrawable)btnList.get(12).getBackground()).getColor() ==listColor[i])
            {
                listColor1[2] = listColor[i];
            }else  if(((ColorDrawable)btnList.get(18).getBackground()).getColor() ==listColor[i])
            {
                listColor1[3] = listColor[i];
            }else if(((ColorDrawable)btnList.get(24).getBackground()).getColor() ==listColor[i])
            {
                listColor1[4] = listColor[i];
            }else  if(((ColorDrawable)btnList.get(30).getBackground()).getColor() ==listColor[i])
            {
                listColor1[5] = listColor[i];
            }else  if(((ColorDrawable)btnList.get(36).getBackground()).getColor() ==listColor[i])
            {
                listColor1[6] = listColor[i];
            }
        }
    }
    public class MyCounter extends CountDownTimer{

        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            newGame.setText("Yeni Oyun");
            newGame.startAnimation(FabOpen);
            newGame.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            count.setText(""+millisUntilFinished/1000);
            // i tried this
        }
    }
}
