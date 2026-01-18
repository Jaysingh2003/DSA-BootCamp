package com.Basic_Interview_questions;

public class Minimum_element {

    public static int minimumElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -5};
        System.out.println(minimumElement(arr));
    }
}