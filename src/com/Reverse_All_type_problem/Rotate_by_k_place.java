package com.Reverse_All_type_problem;

import java.util.Arrays;

/// https://leetcode.com/problems/rotate-array/
/// complexity is O(n) and space complexity is O(1)
public class Rotate_by_k_place {
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k = k % n; // avoids repeated full rotations means if k is greater than n, we only need to rotate k % n times
        /// if nums lenght 6 and k is 8, we only need to rotate 2 times because after 6 rotations, the array will be back to its original position

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        new Rotate_by_k_place().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
