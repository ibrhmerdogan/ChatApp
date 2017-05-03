package com.example.ibrhm.parentlock.Books;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrhm.parentlock.Database.DbOperations;
import com.example.ibrhm.parentlock.Database.MessageDB;
import com.example.ibrhm.parentlock.Parse.Parse;
import com.example.ibrhm.parentlock.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ibrhm on 16.03.2017.
 */

public class Book extends Activity {

    ArrayList<String> pages= new ArrayList<>();
    TextView tt,bookname,textView;
    private static Context context;
    SeekBar seekBar;
    int pagenum = 0;
    int i =0;
    DbOperations operations;
    MessageDB messageDB;
    private int message = 100;
    Parse parse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_view);
        operations();
        dbOperations();
        readOperations();
    }

    private void readOperations()
    {
        final Scanner scanner;
        try
        {
            Resources resources = getResources();
            InputStream stream = resources.openRawResource(R.raw.dosyam);
            scanner= new Scanner(stream);
            page(scanner);

        }catch (Exception e)

        {
            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();
        }
        initBar(seekBar,pagenum);
        tt.setText(pages.get(0));
         message = parse.parseReplecement(message);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pagenum<message)
                {
                    pagenum++;
                    initBar(seekBar, pagenum);
                    if (pagenum < (i + 1)) {
                        String no = String.valueOf((pagenum + 1));

                        tt.setText(pages.get(pagenum));
                    }
                    if (pagenum > (i)) {
                        pagenum--;
                    }
                }
            }
        });
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

    public void page(Scanner scanner)
    {
        String str = "";

        while (scanner.hasNext() && str.length()<950)
        {

            str += " "+scanner.next();
            if(str.length()>940)
            {

                pages.add(i,str);
                i++;
                str = "";
            }
        }
        pages.add(i,str);
    }
   public void initBar(SeekBar bar,  int stream) {

       bar.setMax(pages.size());
       bar.setProgress(stream);

       bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {
               // TODO Auto-generated method stub
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {
               // TODO Auto-generated method stub
           }

           @Override
           public void onProgressChanged(SeekBar seekBar, int progress,
                                         boolean fromUser) {
               // TODO Auto-generated method stub
               int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
               textView.setText("" + (progress+1));
               textView.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    pagenum = progress;
               if(pagenum<pages.size()) {
                   String no = String.valueOf((pagenum + 1));

                   tt.setText(pages.get(pagenum));
               }
           }
       });
   }

   public void operations()
   {
       seekBar = (SeekBar)findViewById(R.id.seekbar);
       textView = (TextView)findViewById(R.id.txtt);
       textView.setText(String.valueOf(1));
       tt=(TextView) findViewById(R.id.textview);
       parse = new Parse();
       bookname = (TextView)findViewById(R.id.name);
       bookname.setText("Bir ailenin hikayesi");
       operations = new DbOperations();
       messageDB = new MessageDB(this);
   }
}
