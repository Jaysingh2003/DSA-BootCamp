package com.recursion;

public class CheckSortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5};
        boolean isSorted = checkSorted(arr, 0);
        if (isSorted) {
            System.out.println("The array is sorted.");
        } else {
            System.out.println("The array is not sorted.");
        }
    }

    static boolean checkSorted(int[] arr, int index) {
        if (arr.length == 0 || arr.length == 1 || index == arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return checkSorted(arr, index + 1);
    }
}