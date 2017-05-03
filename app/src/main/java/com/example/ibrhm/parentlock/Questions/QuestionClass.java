package com.example.ibrhm.parentlock.Questions;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrhm.parentlock.Database.DbOperations;
import com.example.ibrhm.parentlock.Database.MessageDB;
import com.example.ibrhm.parentlock.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ibrhm on 24.03.2017.
 */

public class QuestionClass extends Activity{

    ImageView question;
    Button next;
    List<String> list1 = new ArrayList<>();
    int y = 0;
    int trueAnswer = 0;
    int falseAnswer = 0;
    MessageDB messageDB;
    DbOperations operations;
    private int message = 100;
    List<String> ans = new ArrayList<>();
    TextView number,resultTrue,resultFalse;
    ImageView a,b,c,d,e;
    List<Integer> list = new ArrayList<>();
    String answer[] ={"n","n","n","n","n","n","n","n","n","n","n","n","n","n"};
    int i=0;
    GetQuestions getQuestions= new GetQuestions();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_views);
        operation();
        dbOperations();
        next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 a.setImageResource(R.drawable.a);
                 b.setImageResource(R.drawable.b);
                 c.setImageResource(R.drawable.c);
                 d.setImageResource(R.drawable.d);
                 e.setImageResource(R.drawable.e);
                 i++;
                 if(list.size()>i && list.size()<message) {
                     number.setText(String.valueOf(i+1));
                     question.setImageResource(list.get(i));
                 }else
                     {

                         setContentView(R.layout.questions_key_views);
                         resultTrue = (TextView)findViewById(R.id.truekey);
                         resultFalse = (TextView)findViewById(R.id.falsekey1);
                         resultTrue.setText("DOGRU:"+String.valueOf(trueAnswer));
                         resultFalse.setText("YANLIS:"+String.valueOf(falseAnswer));


                     }

             }
         });


    }
    public void operation()
    {

        next = (Button)findViewById(R.id.btnOk);
        list = getQuestions.getDrawbleId();
        question = (ImageView)findViewById(R.id.img);
        question.setImageResource(list.get(i));
        number = (TextView)findViewById(R.id.textView8);
        number.setText(String.valueOf(i+1));


        getAnswer();
        a = (ImageView)findViewById(R.id.image1);
        b = (ImageView)findViewById(R.id.image2);
        c = (ImageView)findViewById(R.id.image3);
        d = (ImageView)findViewById(R.id.image4);
        e = (ImageView)findViewById(R.id.image5);
        a.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @SuppressWarnings("ResourceAsColor")
            @Override
            public void onClick(View v) {
                answer[i] = String.valueOf("A");
                if(answer[i].equals(list1.get(i).toString()))
                {
                    a.setImageResource(R.drawable.okey);
                    trueAnswer++;
                }
                else
                {

                    a.setImageResource(R.drawable.no);
                    falseAnswer++;

                }

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ResourceAsColor")
            @Override
            public void onClick(View v) {
                answer[i] = String.valueOf("B");
                if(answer[i].equals(list1.get(i).toString()))
                {
                    b.setImageResource(R.drawable.okey);
                    trueAnswer++;
                }
                else
                {
                    b.setImageResource(R.drawable.no);
                    falseAnswer++;
                }
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ResourceAsColor")
            @Override
            public void onClick(View v) {
                answer[i] = String.valueOf("C");
                if(answer[i].equals(list1.get(i).toString()))
                {
                    c.setImageResource(R.drawable.okey);
                    trueAnswer++;
                }
                else
                {
                    c.setImageResource(R.drawable.no);
                    falseAnswer++;
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ResourceAsColor")
            @Override
            public void onClick(View v) {
                //d.setBackgroundColor(R.color.colorPrimary);
                answer[i] = String.valueOf("D");

                if(answer[i].equals(list1.get(i).toString()))
                {
                    d.setImageResource(R.drawable.okey);
                    trueAnswer++;
                }
                else
                {
                    d.setImageResource(R.drawable.no);
                    falseAnswer++;
                }
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ResourceAsColor")
            @Override
            public void onClick(View v) {
                answer[i] = String.valueOf("E");
                if(answer[i].equals(list1.get(i).toString()))
                {
                    e.setImageResource(R.drawable.okey);
                    trueAnswer++;
                }
                else
                {
                    e.setImageResource(R.drawable.no);
                    falseAnswer++;
                }
            }
        });
    }
    public void getAnswer()
    {
        final Scanner scanner;
        try
        {
            Resources resources = getResources();
            InputStream stream = resources.openRawResource(R.raw.questions);
            scanner= new Scanner(stream);
            page(scanner);

        }catch (Exception e)

        {
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();
        }

    }

    public void page(Scanner scanner)
    {

        while (scanner.hasNext())
        {
            list1.add(y,scanner.next());
            y++;
        }
    }
    private void dbOperations()
    {
        try {
            Cursor cursor = operations.getRegister(messageDB);
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex("id"));
                message = Integer.parseInt(cursor.getString((cursor.getColumnIndex("message"))));

            }

        }catch (Exception e){}
    }
}
