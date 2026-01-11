package com.FamousQuestions;

import java.util.Arrays;

/// https://leetcode.com/problems/rotate-array/
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
        k = k % n; // avoids repeated full rotations

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
