package com.operators;

public class XorInRange {
    public static void main(String[] args) {
        int L = 3;
        int R = 9;

        int ans = xorInRange(R) ^ xorInRange(L - 1);//all xor me fir xor (l-1) tak karege to (l-1) tak ki valiue cancel ho jayegi
        System.out.println(xorInRange(ans));            //beacouse of same no is zero;
    }

    //range xor from l to r = xor( r) ^ xor( l-1)
    private static int xorInRange(int l) {
        if (l % 4 == 0) return l;
        if (l % 4 == 1) return 1;
        if (l % 4 == 2) return l + 1;
        return 0;
    }
}
/*
//another do that isway we can
    private static int xorInRange1(int l, int r) {
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans = ans ^ i;
        }
        return ans;
    }
}
*/