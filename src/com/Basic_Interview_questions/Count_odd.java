package com.Basic_Interview_questions;

public class Count_odd {
    public static int countOdd(int[] arr) {
        int count=0;
        for(int num : arr){
            if(num%2 !=0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,5};
        System.out.println(countOdd(arr));
    }
}
