package com.Rising_Brain_Array_Pattern.Kadenes_algorithem;

///https://leetcode.com/problems/maximum-subarray/
public class Maximum_Subarray_sum {
    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
}
