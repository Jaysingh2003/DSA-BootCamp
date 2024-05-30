package com.TWOPOINTER.variablesize;

import java.util.*;


//Given an integer array nums, find all unique triplets
//[nums[i], nums[j], nums[k]] such that:
//	•	i ≠ j ≠ k
//	•	nums[i] + nums[j] + nums[k] = 0
//	•	The solution must not contain duplicate triplets
///  Q-1-  “Find all unique triplets in an array whose sum is zero.”
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // if sum is zero, we found a triplet
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                //if sum is less than zero, we need a larger number, so move left pointer to the right
                else if (sum < 0) {
                    left++;
                }// if sum is greater than zero, we need a smaller number, so move right pointer to the left
                else {
                    right--;
                }
            }
        }
        return result;
    }

    ///  Q-2:-“Find all unique triplets in an array whose sum equals a given target.”

    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }




    ///Q-3:- Three Sum (Return Indices)

    class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public List<List<Integer>> threeSumIndices(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // sort by value
        Arrays.sort(arr, (a, b) -> a.value - b.value);// sort by value in ascending order

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i].value == arr[i - 1].value) continue;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i].value + arr[left].value + arr[right].value;

                if (sum == target) {
                    result.add(Arrays.asList(
                            arr[i].index,
                            arr[left].index,
                            arr[right].index
                    ));

                    while (left < right && arr[left].value == arr[left + 1].value) left++;
                    while (left < right && arr[right].value == arr[right - 1].value) right--;

                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }

}