package com.Rising_Brain_Array_Pattern.Sliding_Window;


////https://leetcode.com/problems/subarray-product-less-than-k/description/
public class Subarray_Product_Less_Than_K {

    /// Broute force
    public int numSubarraysWithProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;///we iuntialize the product 1 at every i iteration
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    /// optimized approch
    public int numSubarraysWithProductLessThanKII(int[] nums, int k) {
        if (k <= 1) return 0;
        int product = 1;
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {/// we use while becaouse we dont know how maney time we have to remove the left side pointer jab tak preoduct k se kam n ho jaye tab take remoive karte rahna h
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
