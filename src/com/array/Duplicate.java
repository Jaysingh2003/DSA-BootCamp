package com.array;

import java.util.Arrays;

public class Duplicate {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,4,6,8};
       boolean num =(duplicatedigit(arr));
        System.out.println(num);

    }
   static boolean duplicatedigit(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j < arr.length-1 ; j++) {
                if(arr[i]==arr[j]){
                    return false;
                }
            }

        }
       return true;
    }
}
