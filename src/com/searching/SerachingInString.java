package com.searching;
import java.lang.String;
import java.util.Arrays;

public class SerachingInString {
    public static void main(String[] args) {
        String name = "jaysingh";
        char target ='s';
        boolean ans =search(name,target);
        System.err.println(ans);
        //for each loop print
       // System.out.println(Arrays.toString(name.toCharArray()));
    }


    static boolean search(String str, char target){
        if(str.length()==0){
            return false;
        }

//        //for ecah loop
//        for(char ch : str.toCharArray()){
//            if(ch ==target){
//                return true
//            }
//
//        }
//        return false;
//
        for(int i=0;i<str.length();i++){
            if(target == str.charAt(i)){
                return true;
            }
        }
        return false;
    }


}
