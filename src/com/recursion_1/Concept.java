package com.recursion_1;

public class Concept {
    public static void main(String[] args) {
        printsesc(5);
    }

    static void printsesc(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printsesc(--n);//this will decrement n first and then pass it to the function
//        printsesc(n--);//this will pass the current value of n to the function and then decrement it
//                         //but it will not affect the current function call be because it call the function again before it value descresing
//        System.out.println(n);

    }
}
