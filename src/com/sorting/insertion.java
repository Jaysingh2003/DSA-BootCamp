package com.sorting;

import java.util.Arrays;

public class insertion {
    public static void main(String[] args) {
     int[] arr={5,3,4,1,2};
     insertoion(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertoion(int[] arr){//we will we sort towrds the left side
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = i+1 ; j >0 ; j--) {
              if(arr[j] < arr[j-1]){
                  swap(arr,j,j-1 );
              }
              else {
                  break;
              }
            }
        }
    }
    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end]=temp;
    }
}
