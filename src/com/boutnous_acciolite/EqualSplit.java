package com.boutnous_acciolite;

/// Split array into two subarrays with equal sum
public class EqualSplit {
    public static boolean canSplit(int[] arr) {
        int total = 0, leftSum = 0;
        for (int num : arr) total += num;

        for (int num : arr) {
            leftSum += num;
            if (leftSum * 2 == total) return true;
        }
        return false;
    }

    //retun the array index where the split occurs
    public static int splitIndex(int[] arr) {
        int total = 0, leftSum = 0;
        for (int num : arr) total += num;
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            if (leftSum * 2 == total) return i;
        }
        return -1;
    }
}