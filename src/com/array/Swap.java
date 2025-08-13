package com.array;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Swap {

    public static void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr ={1,2,4,5,6,8,78};
        System.out.println(Arrays.toString(arr));
        swap(arr,2,5);
    }
}
