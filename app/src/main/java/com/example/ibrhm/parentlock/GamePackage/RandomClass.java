package com.example.ibrhm.parentlock.GamePackage;

import java.util.Random;

/**
 * Created by ibrhm on 23.03.2017.
 */

public class RandomClass {

    int x;
    int z;
    String y = null;
    public int[] randomFunctions( int gelen)
    {
        Random random = new Random();

        int list[] = new int[gelen];


        for (int i = 0; i<gelen; i++)
        {
            if(i != 0) {
                x = random.nextInt(gelen);
                for ( z = 0; z<i; z++)
                {
                    if(list[0] == x || list[z] == x  )
                    {
                        x = random.nextInt(gelen);
                        z = 0;

                    }

                }
                list[i] = x;

            }else
            {
                x = random.nextInt(gelen);
                list[i] = x;
            }


        }

   return list;
    }
}
