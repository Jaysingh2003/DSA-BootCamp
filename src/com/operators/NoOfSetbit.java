package com.operators;

public class NoOfSetbit {

//set bit is the no of bit which is 1 in the binary representation of a number
    public static void main(String[] args) {
        int n = 7;
        System.out.println(Integer.toBinaryString(n));//this will, print the binary representation of n
        int count = countSetBits(n);
        System.out.println(count);
    }

    private static int countSetBits(int n) {
        int count = 0;
        while (n > 0 ) {
            count= count + (n & 1); // check if the last bit is set
            n = n >> 1; // right shift to check the next bit

        }
        return count;

    }
}

