package com.TWOPOINTER.variablesize;


// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description//

public class Maximum_Absolute_Sum_of_Any_Subarray {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int min = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        return max - min;
    }
        public static void main(String[] args) {
            Maximum_Absolute_Sum_of_Any_Subarray solution = new Maximum_Absolute_Sum_of_Any_Subarray();
            int[] nums = {1, -3, 2, 3, -4};
            int result = solution.maxAbsoluteSum(nums);
            System.out.println(result); // Output: 5
        }
}
