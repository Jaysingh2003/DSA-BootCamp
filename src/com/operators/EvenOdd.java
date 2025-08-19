package com.operators;

public class EvenOdd {
    public static void main(String[] args) {
        int num=4;

        System.out.println( isodd(num));
    }

    private static boolean isodd(int num) {//the concept is if we AND with any number with 1, it will return 1 if the number is odd and 0 if the number is even.
        return (num & 1) == 1;
    }

}
