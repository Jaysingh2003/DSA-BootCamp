package com.operators;


//the magic no is like 6 = 1 1 0 in binaery for for each index  5^2 + 5^1 + 5^0 = 6 find like this foe the nth
public class MagicNumber {
    public static void main(String[] args) {

        int n = 3;
        int ans = magic(n);
        System.out.println(ans);
    }

    static int magic(int n) {
        int ans = 0;
        int base = 5;

        while (n > 0) {
            int lastDigit = n & 1; // get the last bit
            n = n >> 1; // right shift n by 1
            ans += lastDigit * base; // add the value of the last bit multiplied by the
            base = base * 5; // increase the base by 5


        }
        return ans;
    }
}