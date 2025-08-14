package com.recursion;

import static java.lang.Integer.max;

public class Min_Max_number {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 8, 2};
        int n = arr.length;
        int[] result = minandmax(arr);
        System.out.println( result[0] + " " + result[1]);

    }

    public static int minimum(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        int minOfRest = minimum(arr, n - 1);

        if(arr[n-1] < minOfRest) {
            return arr[n - 1];
        } else {
            return minOfRest;
        }
    }

    public static int maximum(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        int maxOfRest = maximum(arr, n - 1);

        if(arr[n-1] > maxOfRest) {
            return arr[n - 1];
        } else {
            return maxOfRest;
        }
    }

    static int[] minandmax(int[] arr) {

        int n = arr.length;
        int min = minimum(arr, n);
        int max = maximum(arr, n);
        return new int[]{min, max};
    }
}
