package com.Basic_Interview_questions;

public class Check_array_sorted {

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 5};
        System.out.println(arr.length);
        System.out.println(isSorted(arr)); // false

    }
}