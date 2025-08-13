package com.functions;

import java.util.Arrays;

public class Varargs {

    public static void main(String[] args) {
        fun(1,2,3,4,5,5,6);

        mutipleargs(2,3,"a","b");



    }

    static  void mutipleargs(int a, int b,String ...v){
        System.out.println("a = " + a + ", b = " + b);
        System.out.println(Arrays.toString(v));
    }



    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }
}
