package com.Reverse_All_type_problem;

public class Revserse_subarray_in_Range {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int left = 2;
        int right = 5;
        reverseSubarray(arr, left, right);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void reverseSubarray(int[] arr, int k, int l) {
        while (k < l) {
            int temp = arr[k];
            arr[k] = arr[l];
            arr[l] = temp;
            k++;
            l--;
        }
    }
}
