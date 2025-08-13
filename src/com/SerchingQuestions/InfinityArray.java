package com.SerchingQuestions;

public class InfinityArray {
    public static void main(String[] args) {
     int[] arr = {1,2,4,5,6,75,56,78,98,76,54,33,4,566,777,};
     int target=556;
     int ans = search(arr,target);
        System.out.println(ans);
    }
    static int  search(int[] arr, int target){
        int start=0;
        int end = 1;
        //condition to lie the target the range
         if(target > arr[end]){
           int newstart = end+1;
           //double the box size
             // end = previous end + sizeof * 2

             end = end+(end-start+1)*2;
             start=newstart;
         }
          return  binerysearch(arr,target,start,end);
    }

    static int binerysearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {

                return mid;
            }
        }
        return -1;
    }
}
