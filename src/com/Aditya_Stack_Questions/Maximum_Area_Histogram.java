package com.Aditya_Stack_Questions;

import java.util.*;

/// Maximum Area Histogram
/// Given histogram bar heights,
/// find the largest rectangular area possible.

class Pair {

    int index;
    int value;

    Pair(int value, int index) {
        this.index = index;
        this.value = value;
    }
}

public class Maximum_Area_Histogram {

    // Find nearest smaller element index on left side
    public static int[] nearestSmallerLeft(int[] arr) {

        Stack<Pair> stack = new Stack<>();

        int[] left = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            // Remove all greater/equal elements
            // because they cannot be nearest smaller
            while (!stack.isEmpty() &&
                    stack.peek().value >= arr[i]) {

                stack.pop();
            }

            // If no smaller element exists
            if (stack.isEmpty()) {
                left[i] = -1;
            }

            // Store nearest smaller index
            else {
                left[i] = stack.peek().index;
            }

            // Push current element with index
            stack.push(new Pair(arr[i], i));
        }

        return left;
    }

    // Find nearest smaller element index on right side
    public static int[] nearestSmallerRight(int[] arr) {

        Stack<Pair> stack = new Stack<>();

        int[] right = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            // Remove all greater/equal elements
            while (!stack.isEmpty() &&
                    stack.peek().value >= arr[i]) {

                stack.pop();
            }

            // If no smaller element exists
            if (stack.isEmpty()) {
                right[i] = arr.length;
            }

            // Store nearest smaller index
            else {
                right[i] = stack.peek().index;
            }

            // Push current element with index
            stack.push(new Pair(arr[i], i));
        }

        return right;
    }

    // Calculate maximum rectangle area
    public static int maxArea(int[] arr) {

        int max = Integer.MIN_VALUE;

        // Nearest smaller left
        int[] nsl = nearestSmallerLeft(arr);

        // Nearest smaller right
        int[] nsr = nearestSmallerRight(arr);

        for (int i = 0; i < arr.length; i++) {

            // Width of rectangle
            int width = nsr[i] - nsl[i] - 1;

            // Area = width × height
            int area = width * arr[i];

            // Store maximum area
            max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 4, 5, 1, 6};

        System.out.println("Maximum Area: " + maxArea(arr));
    }
}