package com.recursion;

public class Stringlenth{
    public static void main(String[] args) {
        String str="Hello World";
        System.out.println(lenthString(str));

    }
    public static  int lenthString(String str){

        if(str.equals("")){
            return 0;
        }
        return  lenthString(str.substring(1)) + 1 ;
    }
}
