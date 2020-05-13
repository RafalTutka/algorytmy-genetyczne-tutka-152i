package com.company;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class TimeUtils {
//funkcja zliczająca i wyświetlajaca ilośc ms w sposob 00:00:00
    public static String getPeriodInTime(Instant one, Instant two){
//zliczanie kolejno ilości godzin, minut,sekund na podstawie milisekund
        Long milis= ChronoUnit.MILLIS.between(one,two);
        StringBuilder stringBuilder=new StringBuilder();
        if (TimeUnit.MILLISECONDS.toHours(milis)==0)
            stringBuilder.append(0);
        else
            stringBuilder.append(TimeUnit.MILLISECONDS.toHours(milis)%60);
        stringBuilder.append(":");
        //wylicza ilosc pelnych minut
        if (TimeUnit.MILLISECONDS.toMinutes(milis)==0)
            stringBuilder.append(0);
        else
            stringBuilder.append(TimeUnit.MILLISECONDS.toMinutes(milis)%60);
        stringBuilder.append(":");
        if (TimeUnit.MILLISECONDS.toSeconds(milis)==0)
            stringBuilder.append(0);
        else
            stringBuilder.append(TimeUnit.MILLISECONDS.toSeconds(milis)%60);
        stringBuilder.append(".");
        if ((milis%1000)<10)
            stringBuilder.append("00");

        //kazda wartość jest dodana string buildera który stworzy string
        if((milis%100)<100&&(milis%1000)>10)
        {
            stringBuilder.append("0");
        }
        stringBuilder.append(""+milis%1000);
//zwrocenie ciągu znaków czasu
        return stringBuilder.toString();
    }
}
