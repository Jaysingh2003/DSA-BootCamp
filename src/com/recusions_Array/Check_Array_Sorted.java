package com.recusions_Array;

public class Check_Array_Sorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(checkSorted(arr, 0));
    }

    static boolean checkSorted(int[] arr, int index) {

        if (index == arr.length - 1) {
            return true;
        }
        return (arr[index] < arr[index + 1] && checkSorted(arr, index + 1));


    }
}

//in an array evertime the same array will pass if we chnage the array then it will give the different output