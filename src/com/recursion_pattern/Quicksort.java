package com.recursion_pattern;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr={5,3,8,4,2};
        int n=arr.length;
        sort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int mid=s+(e-s)/2;
        int pivot = arr[mid];

        //this is reason when the array is already sorted then it will not swap
        while(s <= e){
            while(arr[s] < pivot){
                s++;
            }
            while (arr[e] >pivot){
                e--;
            }
            //this condition will again use to check if the element is in the correct position or not
            //because the contion of while loop will check agin only whn the entire code is executed and theremay be
            //be possibility that the element is not in the correct position they will come on the same index
            if(s <= e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        //pivot is its correct posistion  now sort the two halves
        sort(arr, low, e);
        sort(arr, s, high);


    }
}
