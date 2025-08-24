package com.operators;


/*
if a give no the ith n]bit set mens that if the ith bit is one the remain th one and if it zero make it one
we can do it via the orr opertaor
 */
public class IthBitSet {
    public static void main(String[] args) {
        int n = 5; // binary: 0101
        int i = 2; // we want to set the 1st bit

        int result = setIthBit(n, i);
        int newResult = resetIthBit(n, i);
        System.out.println( result);
        System.out.println(newResult);

    }
    public static int setIthBit(int n, int i) {//1-->1 and 0-->1
        return n | (1 << i-1);//for 1 based indexind
    }

    //similerly for the reset bit
   // 1-->0
   // 0-->0
    public static int resetIthBit(int n, int i) {
        return n & ~(1 << i-1); // for 1 based indexing
    }

}
