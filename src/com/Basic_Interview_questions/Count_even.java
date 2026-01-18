package com.Basic_Interview_questions;

public class Count_even {
    public static int countEven(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr={0,2,3,4};
        System.out.println(countEven(arr));
    }
}
