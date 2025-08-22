package com.backtarking;

public class PossibleNumbers {

    static void backtracking(int n ,String str){
         if(str.length()==n){
             System.out.println(str);
             return;
         }
         backtracking(n,str+"0");
         // backTracking when the recursion returns
         backtracking(n,str+"1");

    }

    public static void main(String[] args) {
        String str="";
        backtracking(3,str);
    }
}
