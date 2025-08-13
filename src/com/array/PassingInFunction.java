package com.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PassingInFunction {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        System.out.println(Arrays.toString(nums));//output-[1, 2, 3, 4, 5, 6]
        chnage(nums);
        System.out.println(Arrays.toString(nums));//output-[99, 2, 3, 4, 5, 6]
    }
    //this will change the value beacuse both nums and the arr pointing to the same object
    static void chnage(int[] arr){
        arr[0]=99;
    }

}
