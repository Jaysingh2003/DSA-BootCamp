package com.TWOPOINTER.variablesize;


//vvi
/// Kadane's algorithm is an efficient way to find the maximum sum of a contiguous subarray in an array of integers. The algorithm works by iterating through the array and keeping track of the current sum of the subarray being considered. If the current sum exceeds the maximum sum found so far, it updates the maximum sum.
///  If the current sum becomes negative, it resets it to zero, as a negative sum would not contribute to a maximum sum in the future.
public class    Kadense_algorithems {
    public static int maxsum(int[] arr){
        int max=Integer.MIN_VALUE;
        int currentsum=0;
        for (int i = 0; i < arr.length ; i++) {
            currentsum += arr[i];
            if(currentsum>max){
                max=currentsum;
            }
            if(currentsum<0) {// if the current sum becomes negative, reset it to zero
                currentsum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxsum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}
