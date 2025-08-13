package com.array;

import java.util.HashMap;


public class ReturnIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 13;
        int[] newarr = twosum(arr, target);
        System.out.println("Indexes: " + newarr[0] + ", " + newarr[1]);
    }
       static  int[] twosum ( int[] nums, int target){

            HashMap<Integer,Integer>  map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int  leftnum = target-nums[i];
             // Check if the no (key) already exists
                if(map.containsKey(leftnum)){
                    return new int[]{map.get(leftnum),i};
                }
                // Store the current number and its index
                map.put(nums[i],i);

            }
            return new int[]{};
        }

}
