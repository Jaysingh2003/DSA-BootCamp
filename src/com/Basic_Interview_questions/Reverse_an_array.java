package com.Basic_Interview_questions;

import java.util.Arrays;

public class Reverse_an_array {

    public static int[] reverse(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(arr)));

    }


    /// recusive
    public static void reverseRecursive(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseRecursive(arr, start + 1, end - 1);
    }

}