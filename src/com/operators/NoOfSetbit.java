package com.operators;

public class NoOfSetbit {

    public static void main(String[] args) {
        int n = 9; // binary: 11101
        int count = countSetBits(n);
        System.out.println(count);
    }

    private static int countSetBits(int n) {
        int count = 0;
        while ((n & 1) == 1) {
            count++;
            n = n >> 1; // right shift to check the next bit

        }
        return count;

    }
}

