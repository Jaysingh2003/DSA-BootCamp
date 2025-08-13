package com.sorting;

import java.util.Arrays;

public class Cyclicsort {
    public static void main(String[] args) {
   int[] arr={3,2,1,4,5};
   cyclicsort(arr);
   System.out.println(Arrays.toString(arr));
    }
    static  void  cyclicsort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else {
                i++;
            }

        }
    }
    static  void swap(int[] arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
         arr[end]=temp;
    }

}
