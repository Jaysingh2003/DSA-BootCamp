package com.recursion_pattern;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        arr = mergesort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {5, 4, 3, 2, 1};
        mergesortInplace(arr2,0, arr2.length);
        System.out.println(Arrays.toString(arr2));

    }

    static int[] mergesort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;//this is the pointer for mix array
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;//k is the ne array pinter  and we have to move it every time either from first or second array added

        }
        //it may be possible that one of the arrays is not completely traversed
        //so we have to copy the remaining elements of that array
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;

    }

    //inplace merge sort (without using extra space


      static void mergesortInplace(int[] arr, int s, int e){
        if(e-s==1){//if there is only one element
            return;
        }
        int mid = s+(e-s)/2;
        mergesortInplace(arr,s,mid);
        mergesortInplace(arr,mid,e);
        mergeInplace(arr,s,mid,e);
      }
        static void mergeInplace(int[] arr, int s, int mid, int e){
            int[] mix = new int[e-s];
            int i = s;
            int j = mid;
            int k = 0;//this is the pointer for mix array
            while (i < mid && j < e) {
                if (arr[i] < arr[j]) {
                    mix[k] = arr[i];
                    i++;
                } else {
                    mix[k] = arr[j];
                    j++;
                }
                k++;//k is the ne array pinter  and we have to move it every time either from first or second array added

            }
            //it may be possible that one of the arrays is not completely traversed
            //so we have to copy the remaining elements of that array
            while (i < mid) {
                mix[k] = arr[i];
                i++;
                k++;
            }
            while (j < e) {
                mix[k] = arr[j];
                j++;
                k++;
            }
            //copy the mix array to original array
            for(int l=0;l<mix.length;l++){
                arr[s+l]=mix[l];
            }
        }
}
