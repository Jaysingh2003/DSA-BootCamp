package com.recursion;

import java.util.*;

public class Staircase {
    static Map<Integer,Integer> memo = new HashMap<>();

    static int ways(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;      // one way: take no step
        if (memo.containsKey(n)) return memo.get(n);
        int ans = ways(n-1) + ways(n-2) + ways(n-3);
        memo.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ways(5)); // prints 13
    }
}