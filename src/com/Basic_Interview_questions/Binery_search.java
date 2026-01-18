package com.Basic_Interview_questions;

public class Binery_search {
    public static  int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>arr[mid]){
                start=mid+1;

            } else if (target<arr[mid]) {
                end=mid-1;
            }else {
                return mid;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int index = binarySearch(arr, 5);
        if (index != -1) {
            System.out.println("Found at index " + index);
        }
        else{
            System.out.println("Not found");
        }
    }

    /// Recursive Binary Search
    public static int binarySearchRec(int[] arr, int target, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) return mid;
        if (target < arr[mid])
            return binarySearchRec(arr, target, start, mid - 1);
        else
            return binarySearchRec(arr, target, mid + 1, end);
    }
}
