package com.example.ibrhm.parentlock.Language;

import com.example.ibrhm.parentlock.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrhm on 3.04.2017.
 */

public class GetPictureId {
    List<Integer> list = new ArrayList<>();

    public List<Integer> getId()
    {

        list.add(R.drawable.lunch);
        list.add(R.drawable.canteen);
        list.add(R.drawable.school);
        list.add(R.drawable.homework);
        list.add(R.drawable.television);
        list.add(R.drawable.chess);
        list.add(R.drawable.lesson);
        list.add(R.drawable.home);
        list.add(R.drawable.bed);
        list.add(R.drawable.gotobed);
        list.add(R.drawable.book);
        list.add(R.drawable.readbook);
        list.add(R.drawable.getup);
        list.add(R.drawable.returnhome);

        return list;
    }
}
