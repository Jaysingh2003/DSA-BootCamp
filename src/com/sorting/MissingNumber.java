package com.sorting;
//https://leetcode.com/problems/missing-number/description/
public class MissingNumber {
    public static void main(String[] args) {
    int[] arr= {2,4,5,1};
    System.out.println(missingno(arr));
    }
   public static  int missingno(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[arr[i]]) {// arr[i] != arr[arr[i]] this will comaper with the elemtnwith itslef
                swap(arr,i,correct);
            }else {
                i++;
            }
        }
       //case :1 -search fot hte first missing number
       for (int j = 0; j < arr.length; j++) {
           if (arr[j] != j) {
               return j;
           }
       }

   //case:2- // If all indices are correct, the missing number is arr.length
    return arr.length;
    }
    static  void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
}
