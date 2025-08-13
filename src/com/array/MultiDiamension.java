package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDiamension {
    public static void main(String[] args) {


//    int[][]  arr= new int[3][3];//row is necessary but the column may or ma not be necssary
//
//
//    int[][] arr2 = {
//            {1,2,3},//0th index
//            {4,5},//1st index
//            {6,7,8,9}//2nd index
//
//    };
        Scanner sc = new Scanner(System.in);

        int[][] arr=new int[3][3];
        System.out.println(arr.length);//3


        //input format
        for (int row = 0; row <arr.length ; row++) {
            //for each col in every row
            for (int col = 0; col <arr[0].length; col++) {
                arr[row][col] = sc.nextInt();
            }
;
        }

  //Output format 1st method
//        for (int row = 0; row <arr.length ; row++) {//
//            //for each col in every row
//            for (int col = 0; col <arr[0].length; col++) {
//                System.out.print(arr[row][col] + " ");
//            }
//            System.out.println();
//
//        }
    //2nd method  to print the  aarry arr[row] ko conevrt ker diya h array format me
//        for (int row = 0; row <arr.length ; row++) {
//            System.out.println(Arrays.toString(arr[row]));

// 3rd method  using the for each loop
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
        }
}

