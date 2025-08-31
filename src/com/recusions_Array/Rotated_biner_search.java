package com.recusions_Array;

public class Rotated_biner_search {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 1;
        int ans = rotatedBinarySearch(arr, target, 0, arr.length - 1);
        System.out.println(ans);
    }

    static int rotatedBinarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // Left half is sorted
        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target < arr[mid]) {
                return rotatedBinarySearch(arr, target, start, mid - 1);
            } else {
                return rotatedBinarySearch(arr, target, mid + 1, end);
            }
        }

        // Right half is sorted
        else {
            if (arr[mid] < target && target <= arr[end]) {
                return rotatedBinarySearch(arr, target, mid + 1, end);
            } else {
                return rotatedBinarySearch(arr, target, start, mid - 1);
            }
        }
    }
}
