package com.boutnous_acciolite;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/


///Note :- first do using the brute force approach and then optimize it using HashMap.
/// optimal solution using HashMap complxity O(n) time and O(n) space
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];///note here we caluclate the copmplement evertime with the target


             // check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // if not found, add the current number and its index to the map (take no as key and index as value)
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /// brute force solution O(n^2) time and O(1) space
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};

                }
            }
        }

        return new int[]{};
    }
}