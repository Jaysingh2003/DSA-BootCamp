package com.Rising_Brain_Array_Pattern.Prefix_Sum;

import java.util.HashMap;
////count the subaay whose sum is equal to k
public class Subarray_Sum_Equals_K {

    /// Broute Forec
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /// Optimized appproch
    /// Prefix Sum + HashMap

    public int sub_ArraySum(int[] nums, int k) {
        int prefixsum = 0;/// it contains the entire arraey sum one by one..
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);///for intialization nums = [3] , k = 3 , -> prefixSum = 3, target = prefixSum - k = 0,
        ///If 0 is already in the map, we find one valid subarray.-> map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixsum += nums[i];
            int target = prefixsum - k;/// if the target value is -ve let sey it means they are not in the map so we put in the max
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);///the key=prefixsum if that index and value is how maney time it will copme
        }
        return count;
    }


    public static void main(String[] args) {
        Subarray_Sum_Equals_K s = new Subarray_Sum_Equals_K();
        System.out.println(s.sub_ArraySum(new int[]{1, 2, 3,3}, 3));
    }
}