package com.recursion;

import java.util.Arrays;

public class ConstructTriangle {
    public static void main(String[] args) {
     int[] arr={1, 2, 3, 4, 5};
     constructTriangle(arr);
    }
    static void constructTriangle(int[] arr) {

        if(arr.length<1){//base case
            return;
        }

        int[] temp = new int[arr.length-1];

        for(int i=0; i < arr.length-1; i++){
            int x  =arr[i] + arr[i+1];
            temp[i]=x;
        }
        constructTriangle(temp); //recursive call

        System.out.println(Arrays.toString(arr));
    }
}
