package com.oops;

public class Wrapper {
    public static void main(String[] args) {
        int a=10;
        int b=20;

        //primitive will never be swap
        //ans:10 20
        swap(a,b);
        System.out.println(a+" "+b);

     // using the wrapper classes it still not change
        //ans:10 20
        Integer c=10;
        Integer d=20;
        swapwrapper(c,d);
        System.out.println(c+" "+d);



    }
    static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
    static void swapwrapper(Integer a,Integer b){
        Integer temp=a;
        a=b;
        b=temp;
    }
}
