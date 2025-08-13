package com.functions;

public class swap {
    public  static  void swapNumber (int a, int b){
        int temp = a;
         a = b;
         b = temp;
        System.out.println("Inside swap: a=" + a + ", b=" + b);
    }
    public static void main(String[] args) {
        int x = 10, y = 20;
        swapNumber(x, y);
        System.out.println("After swap: x=" + x + ", y=" + y); // Still 10 and 20
    }
    }

