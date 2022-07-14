package com.example.service;

public class Tudien {
   public static String [] english={"cat", "dog", "bird"};
   public static String [] viet={"meo", "the", "chim"};


    public int check(String e){
        for (int i = 0; i <english.length ; i++) {
            if (english[i].equalsIgnoreCase(e)){
                return i;
            }
        }
        return -1;
    }

}
