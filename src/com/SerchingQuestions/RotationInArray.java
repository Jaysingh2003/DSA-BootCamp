package com.SerchingQuestions;

public class RotationInArray {
    public static void main(String[] args) {
    int[] arr={4,5,6,7,8,1,2};
        System.out.println(countrotation(arr));
    }

    private static int countrotation(int[] arr) {
        int pivot = findpivot(arr);
        return arr[pivot+1] ;
    }

    private static int findpivot(int[] arr) {
        int start=0;
            int end = arr.length-1;
            //edge casees
            if (arr == null || arr.length == 0){
                return -1;
            }

            while(start<end){
                int mid= start + (end-start)/2;
                //all four casses
                //if the mid is the greater element
                if(mid < end && arr[mid] >arr[mid +1]){
                    return mid;
                }
                //
                if(mid > start && arr[mid] < arr[mid -1]){
                    return mid-1;
                }
                if(arr[mid] <= arr[start]){
                    end= mid-1;
                }else {
                    start=mid +1;
                }
            }
            return -1;
        }
    }


