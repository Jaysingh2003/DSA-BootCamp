package com.Reverse_All_type_problem;

import java.util.Arrays;
///type-1  using two pointer approach complexity O(n) and space complexity O(1)
public class Reverse_an_Arrray {
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

        ///type-2  recusive complexity O(n) and space complexity O(n) because of the recursive call stack
    public static void reverseRecursive(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseRecursive(arr, start + 1, end - 1);
    }

    /// using broutforce complexity O(n) and space complexity O(n) because we are creating a new array to store the reversed elements
    public static int[] reverseBruteForce(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];  // Note: -1 fixes off-by-one
        }
        return reversedArr;
    }




}
