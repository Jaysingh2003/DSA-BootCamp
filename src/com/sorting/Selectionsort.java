package com.sorting;

import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
      int[] arr = {5,4,1,2,3};
      selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void  selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;//last index (length-1 is the last index and we will
                                         // move every time i less than because of then last element is already sorted
            int maxIndex = getMaxIndex(arr, 0,last);
            swap(arr, maxIndex, last);

        }
    }
    static  void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] =temp;
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
