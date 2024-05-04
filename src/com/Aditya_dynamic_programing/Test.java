package com.Aditya_dynamic_programing;

public class Test {
    static int count(String s){
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println( count("a,shasgaaa"));


    }
}
