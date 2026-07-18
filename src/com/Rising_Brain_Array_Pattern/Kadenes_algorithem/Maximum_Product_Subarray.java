package com.Rising_Brain_Array_Pattern.Kadenes_algorithem;

/// https://leetcode.com/problems/maximum-product-subarray/description/
public class Maximum_Product_Subarray {
    public static int maxProduct(int[] nums) {
        int prefix = 1;
        int sufix = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (sufix == 0) sufix = 1;

            prefix *= nums[i];
            sufix *= nums[n - 1 - i];
            ans = Math.max(ans, Math.max(prefix, sufix));
        }
        return ans;
    }

    /// second approch can also be done by dynamic programming
    /// becouse when we encounter a negative number the max can become min and min can become max\
    /// that is why we have to chnage the maximum to min and min to max
    public static int maxProduct1(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            ans = Math.max(ans, maxProduct);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }
}
