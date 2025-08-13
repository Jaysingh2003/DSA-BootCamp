package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class Sw {
    public static void swap1(int[] arr, int num1, int num2){
        int temp= arr[num1];
        arr[num1]=arr[num2];
        arr[num2]=temp;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr={1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(arr));
        swap1(arr,2,3);

    }
}
