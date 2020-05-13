package com.company;

public class CharUtils {
//zamiana tablicy charów na ciąg znaków String
     public static String parseCharTableToString(char[] chars){
        StringBuilder stringBuilder=new StringBuilder();
        for(char i:chars)
        {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}