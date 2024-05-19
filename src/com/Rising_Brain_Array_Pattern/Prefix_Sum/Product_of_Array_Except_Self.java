package com.Rising_Brain_Array_Pattern.Prefix_Sum;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of
 all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
*/

/// Broute  force
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = 1;   // Initialize to 1
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    res[i] *= nums[j];
                }
            }
        }
        return res;
    }


    /// /optimised approch


    public int[] productExacptItself(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            res[0] = 1;
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }
}



