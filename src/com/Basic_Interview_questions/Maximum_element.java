package com.Basic_Interview_questions;

public class Maximum_element {
    public static int maximumElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={68,8,80,9};
        System.out.println(maximumElement(arr));
    }
}
