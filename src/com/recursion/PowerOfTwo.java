package com.recursion;

public class PowerOfTwo {
    public static void main(String[] args) {
       isPowerOfTwo(34);
       System.out.println(isPowerOfTwo(32));
       System.out.println(isPowerOfTwo(12));
    }
    static public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;//-ve no is the power of 2,and 0 ia also
        if (n==1) return true ;//2^0=1
        if(n% 2 !=0) return false;
        return isPowerOfTwo(n/2);

    }
}

