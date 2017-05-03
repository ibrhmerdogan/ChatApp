package com.example.ibrhm.parentlock.Parse;

/**
 * Created by ibrhm on 13.04.2017.
 */

public class Parse {

    public int parseReplecement(int command)
    {
        int command1 = 0;

        if(command == 1 || command==8 || command==15)
        {
            command1 = 10;
        }else if(command == 2 || command==9 || command==16)
        {
            command1 = 15;
        } else  if(command == 3 || command==10 || command==17)
        {
            command1 = 20;
        }else  if(command == 4 || command==11 || command==18)
        {
            command1 = 25;
        }else  if(command == 5 || command==12 || command==19)
        {
            command1 = 30;
        }else  if(command == 6 || command==13 || command==20)
        {
            command1 = 40;
        }else  if(command == 7 || command==14 || command==21)
        {
            command1 = 50;
        }else if(command == 25 || command == 32)
        {
            command1 =10;
        }else if(command == 26 || command == 33)
        {
            command1 =20;
        }else if(command == 27 || command == 34)
        {
            command1 =30;
        }else if(command == 28 || command == 35)
        {
            command1 =60;
        }else if(command == 29 || command == 36)
        {
            command1 =120;
        }else if(command == 30 || command == 37)
        {
            command1 =180;
        }else if(command == 31 || command == 38)
        {
            command1 =300;
        }

        return command1;
    }

    

}
