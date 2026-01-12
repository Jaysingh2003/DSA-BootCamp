package com.FamousQuestions;

import java.util.HashMap;

public class TwoSum {
    /// O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // return -1 if no solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 71, 11, 15};
        int target = 13;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    /// optimise O(n)
    public class TwoSum1 {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                if (map.containsKey(complement)) {// The complement is already present and the value is used as the key and the index
                                                    //is used as the value at that key
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);// value ko map ki index ke jais istmal kiya gaya h
            }
            return new int[]{-1, -1};
        }
    }
}