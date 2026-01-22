package com.TWOPOINTER.variablesize;


//vvi
//If a subarray sum becomes negative, it is better to discard it, because it cannot contribute to a maximum sum in the future.
public class Kadense_algorithems {
    public static int maxsum(int[] arr){
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
        System.out.println(maxsum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}
