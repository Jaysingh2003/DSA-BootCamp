package com.FamousQuestions;

/// https://leetcode.com/problems/majority-element/description/
public class Majority_element {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Majority_element me = new Majority_element();
        int[] nums = {3, 2, 3};
        System.out.println(me.majorityElement(nums)); // Output: 3
    }
}
// Time Complexity: O(n)
