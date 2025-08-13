package com.SerchingQuestions;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 45, 5, 2, 1};
        int target = 5;
        int result = search(arr, target);
        System.out.println("Target found at index: " + result);
    }

    public static int search(int[] arr, int target) {
        int peak = peakElementSearch(arr);

        // First try to find in the ascending part
        int firstTry = orderAgnosticBinarySearch(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        // Try to find in the descending part
        return orderAgnosticBinarySearch(arr, target, peak + 1, arr.length - 1);
    }

    //fot the finding of the peak element
    public static int peakElementSearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // You're in the descending part of the mountain
                end = mid;
            } else {
                // You're in the ascending part of the mountain
                start = mid + 1;
            }
        }
        // start == end is the peak
        return start;
    }

    public static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1; // Target not found
    }
}