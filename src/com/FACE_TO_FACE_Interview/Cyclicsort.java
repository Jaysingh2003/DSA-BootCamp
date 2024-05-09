package com.FACE_TO_FACE_Interview;

import java.util.Arrays;

//we recognize the pattren of the cyclic sort when the no is given ( 1 to n) then it will be cyc;i sort.
//The cyclic sort is used  when its given that (1 to n) it means we can match the index and  it value beacoiuse the index also start from the 0 to n
// Case 1: Numbers from 1 to n -> Since array index starts from 0,but numbers start from 1. int correctIndex = arr[i] - 1;
//in cyclic sort if (0 to n) give then we check the condition  -> int correctIndex = arr[i];
public class Cyclicsort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicsort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctind = arr[i] - 1;//the corrcet will store the index not the value
            if (arr[i] != arr[correctind]) {//if the value of the corrcet index  and index are (npte we can swap the value no the index )
                swap(arr, i, correctind);// (i , correctind) both are index and in swap methos we will replace its value
            } else {
                i++;
            }

        }
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
