package com.operators;


//find the xor of all numbers from 0 to a
public class XorOfNoFromZeroToA {
    public static void main(String[] args) {
        int a = 3;
        System.out.println(xorFromZeroToA(a));
    }

    private static int xorFromZeroToA(int a) {
        if (a % 4 == 0) {
            return a;
        } else if (a % 4 == 1) {
            return 1;
        } else if (a % 4 == 2) {
            return a + 1;
        } else {// a % 4 == 3
            return 0;
        }
    }
}
