package com.Rising_Brain_Array_Pattern.Prefix_Sum;
import java.util.HashMap;
/*
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:
its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
 */
public class Continuous_Subarray_Sum {
    public boolean checkSubrraeySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);///we put 0,-1] beacuse  if only two elemnt are the modula wull save 0,1 but the 1-0 is 1 so to make a valide two
        ///we have to add alrady -1 so 1-(-1) = > 2 which is valid
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int mod = prefixSum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}

