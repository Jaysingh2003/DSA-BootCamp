package com.FamousQuestions;

public class Maximum_element {
    public static int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8, -1, 4};
        System.out.println("Maximum element in the array: " + maxElement(arr));
    }
}
