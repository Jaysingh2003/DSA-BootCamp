package com.SerchingQuestions;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=problem-list-v2&envId=array
public class FindTheFirstAndLastIndex {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(arr, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] searchRange(int[] arr, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(arr, target, true);  // Find starting index
        ans[1] = search(arr, target, false); // Find ending index
        return ans;
    }

    // Helper function to find first or last position
    private static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // Target is found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1; // Look left side
                } else {
                    start = mid + 1; // Look right side
                }
            }
        }
        return ans;
    }
}