package com.backtarking;
/// This program will print all the possible numbers of 0 and 1 of length n
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
