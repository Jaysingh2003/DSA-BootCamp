package com.recursion_1;

public class ReverseOfNumbers {

    public static void main(String[] args) {
        int n = 12340650;   //but for the zerors it will not work 01243264 it will fail
                            //The code does not handle numbers with leading zeros correctly
                            //because integer literals like 01234065 are interpreted as
                            //octal (base 8) in Java, not decimal.

        reverseNumber(n);
        System.out.println("Reversed Number: " + sum);

    }
    static  int sum = 0;
    static void reverseNumber(int n) {

        if(n == 0){
            return;
        }
        int digit = n % 10;
        sum = sum * 10 + digit;
        reverseNumber(n / 10);

    }
}
