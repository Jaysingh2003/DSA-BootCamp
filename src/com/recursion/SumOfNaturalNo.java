package com.recursion;

public class SumOfNaturalNo {
    public static void main(String[] args) {
         int n=5;
         int sum = sum(n);
        System.out.println(sum);
    }
    static int sum(int n){
        if(n<=1){
            return n;
        }
        return n+ sum(n-1);
    }
}

//Time complexity : O(n)
//Auxiliary space : O(n)

