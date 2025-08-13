package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];//first way to enter the elemrnt in the array
        arr[0]=23;
        arr[1]=23;
        arr[2]=23;
        arr[3]=23;
        arr[4]=23;
        System.out.println(Arrays.toString(arr));



        //second way bi using the loop
        for (int i = 0; i < arr.length; i++) {
            arr[i]= input.nextInt();
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");

        }
        //array of objects
        String[] str= new String[5];
        for (int i = 0; i < str.length ; i++) {
            str[i]= input.next();

        }
        System.out.println(Arrays.toString(str));
    }
}
