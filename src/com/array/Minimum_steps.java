package com.array;

//https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/?envType=daily-question&envId=2025-11-29
public class Minimum_steps {
    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return helper(sum, k);
    }

    int helper(long sum, int k) {
        int remainder = (int) ((sum % k + k) % k);
        return remainder;
    }
}
