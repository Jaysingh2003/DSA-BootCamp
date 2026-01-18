package com.Basic_Interview_questions;

public class Order_agnostic_binerysearch {
    static  int orderagnosticbinersearch(int[] arr , int target){
        int start = 0;
        int end = arr.length - 1;

        //find whether the array is ascending or descending order
        boolean isAsc = arr[start]< arr[end];

        while (start<=end){
            int mid=start+(end-start)/2;

            //mid is common to bithe asc and dec
            if(arr[mid] == target){
                return mid;
            }
            //checkd if ascending order
            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {//if descending order
                if(target > arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {100,90,78,56,45,34,23,12,0};
        int target=45;
        int ans=orderagnosticbinersearch(arr,target);
        System.out.println(ans);
    }
}
