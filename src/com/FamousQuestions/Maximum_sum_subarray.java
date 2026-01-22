package com.FamousQuestions;


//Kadense_algorithems is an efficient algorithm to find the maximum sum of a contiguous subarray in an array of integers.
//The algorithm works by iterating through the array and maintaining a running sum of the current subarray.
//If the running sum becomes negative, it is reset to zero, as a negative sum would
public class Maximum_sum_subarray {
    public static int maxsum(int[] arr) {
        int max=Integer.MIN_VALUE;
        int currentsum=0;
        for (int i = 0; i < arr.length ; i++) {
            currentsum += arr[i];
            if(currentsum>max){
                max=currentsum;
            }
            if(currentsum<0) {
                currentsum = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum of contiguous subarray: " + maxsum(arr));
    }
}