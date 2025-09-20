package com.LinkedList;

//https://leetcode.com/problems/happy-number/description/
public class HappyNumber {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = findsquare(slow);
            fast = findsquare(findsquare(fast));
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;

    }

    private int findsquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n = n / 10;
        }
        return ans;
    }
}
