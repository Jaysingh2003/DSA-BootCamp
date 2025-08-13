package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllIndexes {
    public static void main(String[] args) {
        int[] arr= {1,3,5,7,8,9,10};

        System.out.println(findDisappearedNumbers(arr));
    }
     static public List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
         while( i < arr.length){
             int correct = arr[i]-1;
             //Only compute correct after confirming the number is in the valid range (1 <= arr[i] <= arr.length):
             if(arr[i] > 0  && arr[i] <= arr.length && arr[i] != arr[correct]   ){
                 swap(arr,i,correct);
             }else {
                 i++;
             }
         }
         //add the missing no inn the list
         List<Integer> list =new ArrayList<>();
         for (int j= 0; j < arr.length; j++) {
            if(arr[j] != j+1){
                list.add(j +1);
            }
         }
  return list;
             }
    static  void swap(int[] arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
         }
        
