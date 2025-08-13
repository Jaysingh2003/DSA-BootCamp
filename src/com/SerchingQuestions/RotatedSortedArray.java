package com.SerchingQuestions;
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=array
public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(findpivot(arr));
    }

    static  int search(int[] arr,int target){
     int pivot = findpivot(arr);
     //if pivot is not find it means the array is not rotated
        if(pivot ==-1){
            return binerysearch(arr,target,0 , arr.length-1);
        }
        //if the pivot is found then you have two ascending array
        if (arr[pivot] == target){
            return pivot;
        }//left side tak
        if(target >= arr[0]){
            return  binerysearch(arr,target,0,pivot-1);//for the right side check
        }
        return binerysearch(arr,target,pivot+1,arr.length-1);
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


    //find the pivot elemmnet
    static  int findpivot (int[] arr){
        int start=0;
        int end = arr.length-1;
        //edge casees
        if (arr == null || arr.length == 0){
            return -1;
        }

        while(start<end){
            int mid= start + (end-start)/2;
            //all four casses
            if (mid < end && arr[mid] >arr[mid +1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid -1]){
                return mid-1;
            }
            if(arr[mid] <=arr[start]){
                end= mid-1;
            }else {
               start=mid +1;
            }
        }
     return -1;
    }

    //if ther the duplicate in the array then
//    static  int findpivot (int[] arr){
//        int start=0;
//        int end = arr.length-1;
//        //edge casees
//        if (arr == null || arr.length == 0){
//            return -1;
//        }
//
//        while(start<end){
//            int mid= start + (end-start)/2;
//            //all four casses
//            if(mid < end && arr[mid] >arr[mid +1]){
//                return mid;
//            }
//            if(mid > start && arr[mid] < arr[mid -1]){
//                return mid-1;
//            }
//           //if the element at end middle, start,end,are equal the skip the duplicate
//            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
//                //note:- but it may chnce that these elemnt is the may be an pivot so checked it before he skiping
//                //check if start in pivot;
//                if(arr[start]>arr[start+1]){
//                    return start;
//                }
//                start++;
//                //check wheather end is pivot
//                if(arr[end] < arr[end-1]){
//                    return  end-1;
//                }
//                end--;
//            } else if (arr[start] < arr[mid]  || (arr[start]==arr[mid] && arr[mid] > arr[end] )){
//                start=mid +1;
//            }else {
//                end=end-1;
//            }
//        }
//        return -1;
//    }

}
