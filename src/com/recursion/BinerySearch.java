package com.recursion;

public class BinerySearch {
    public static void main(String[] args) {
    int[] arr = {1,2,4,5,6,75,566,777};//sorted array
    int target = 6;
    int result = binerySearch(arr, target, 0, arr.length - 1);
        System.out.println("Element found at index: " + result);
    }
    static int binerySearch(int[] arr,int target,int start,int end){//this arguments must be passed during the calling of the function

        if(start>end){
            return -1;
        }

        int mid=start+(end-start)/2;

        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            return  binerySearch(arr,target,start,mid-1);
        }
        return binerySearch(arr,target,mid+1,end);

    }
}
