package com.Basic_Interview_questions;

public class Sum_Of_Array_ele {

    public static int sumOfArray(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array is null");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sumOfArray(arr));
    }



    ///  recursive approach
    public static int max(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return Math.max(arr[index], max(arr, index + 1));
    }
}