package com.searching.binerysearch;

public class BinerySearch {
    public static void main(String[] args) {
        int[] arr={-10,-6,0,3,6,8,23,45,67,78};//array must be sorted
        int target=45;
        int ans= binerysearch(arr,target);
        System.out.println(ans);

    }
//return the index
//-1 if the no is not exist
    static  int binerysearch(int[] arr, int target){
        int start=0;
        int end= arr.length-1;
        while (start<=end){
            //find the middle element
            //int mid=(start+end)/2  then it ma be possible that (start+end) it violet the inter limit
            int mid = start +(end-start)/2;

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
}