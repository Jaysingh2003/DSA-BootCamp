package com.functions;

public class swapByRefrence {
    public static void swapno(int[] arr){
       int temp= arr[0];
        arr[0] = arr[1];
        arr[1] = temp;

    }

    public static void main(String[] args) {
       int nums []={10,20};
       swapno(nums);
        System.out.println("After swap: x=" + nums[0] + ", y=" + nums[1]); // Swapped!
    }
}
