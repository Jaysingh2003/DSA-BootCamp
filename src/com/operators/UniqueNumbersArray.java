package com.operators;

import java.util.Arrays;

public class UniqueNumbersArray {
    public static void main(String[] args) {
        int[] arr = {4, 5,  4,  5, 8};
        System.out.println("Unique number is: " + uniqueNumber(arr));


//use this when we have to find the unique numbers in the array ont only the signle array but more that one uniq elemnt in the array
        // Step 1: Sort
//        Arrays.sort(arr);
//
//        System.out.println("Unique numbers: ");
//        // Step 2: Scan neighbors
//        for (int i = 0; i < arr.length; i++) {
//            if ((i == 0 || arr[i] != arr[i - 1]) &&  // Not same as left
//                (i == arr.length - 1 || arr[i] != arr[i + 1])) { // Not same as right
//                System.out.print(arr[i] + " ");
//            }
//        }
    }
    //using the bitwise  XOR fumctionality to find unique number if same no then it will return 0 otherwise it will return the unique number
    static int  uniqueNumber(int[] arr){
        int unique = 0;
        for (int num : arr) {
            unique ^= num; // XOR operation
        }
        return unique;
    }
}