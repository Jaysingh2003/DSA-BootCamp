package com.FamousQuestions;

public class Find_minimum_element {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        int minElement = findMinimum(arr);
        System.out.println("The minimum element in the array is: " + minElement);
    }

    public static int findMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
