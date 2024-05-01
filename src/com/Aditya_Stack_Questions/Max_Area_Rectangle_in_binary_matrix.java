package com.Aditya_Stack_Questions;


import java.util.*;

/// Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
/// Example:
///
/// Input :   0 1 1 0
///           1 1 1 1
///           1 1 1 1
///           1 1 0 0
///

class Pair0 {

    int index;
    int value;

    Pair0(int value, int index) {
        this.index = index;
        this.value = value;
    }
}

public class Max_Area_Rectangle_in_binary_matrix {

    public static int maxArea(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Copy first row
        int[] hist = new int[m];

        for (int i = 0; i < m; i++) {
            hist[i] = matrix[0][i];
        }

        int maxArea = MAH(hist);

        // Process remaining rows
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0)
                    hist[j] = 0;
                else
                    hist[j] += matrix[i][j];
            }

            maxArea = Math.max(maxArea, MAH(hist));
        }

        return maxArea;
    }

    // Maximum Area Histogram
    public static int MAH(int[] arr) {

        int max = Integer.MIN_VALUE;

        int[] nsl = nearestSmallerLeft(arr);
        int[] nsr = nearestSmallerRight(arr);

        for (int i = 0; i < arr.length; i++) {

            int width = nsr[i] - nsl[i] - 1;

            int area = width * arr[i];

            max = Math.max(max, area);
        }

        return max;
    }

    public static int[] nearestSmallerLeft(int[] arr) {

        Stack<Pair0> stack = new Stack<>();

        int[] left = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() &&
                    stack.peek().value >= arr[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek().index;
            }

            stack.push(new Pair0(arr[i], i));
        }

        return left;
    }

    public static int[] nearestSmallerRight(int[] arr) {

        Stack<Pair0> stack = new Stack<>();

        int[] right = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    stack.peek().value >= arr[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = arr.length;
            } else {
                right[i] = stack.peek().index;
            }

            stack.push(new Pair0(arr[i], i));
        }

        return right;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        System.out.println("Maximum Area: " + maxArea(matrix));
    }
}