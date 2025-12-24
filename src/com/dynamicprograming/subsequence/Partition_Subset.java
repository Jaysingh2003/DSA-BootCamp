package com.dynamicprograming.subsequence;

import java.util.Arrays;

public class Partition_Subset {
    int[][] dp;
    public boolean partitionSubset(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {// If total sum is odd, cannot partition into two equal subsets
            return false;
        }
        int target = totalSum / 2;
        int n = nums.length;
        dp = new int[n][target + 1];///we take the size n*target+1 because we are using 0 based indexing and taget can be 0 also
                                    /// so 0 to target, means target+1 size
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return  helper(n - 1, target, nums);



    }
    private  boolean helper(int n, int target, int[] arr) {
        if(target==0) return true;//if target is 0 we found the subset
        if(n==0) return arr[0]==target;//when we reach the first elemnt then we havon only one option
                                        //to check if that element is equal to target or not if yes return true else false
        if(dp[n][target]!=-1){
            return dp[n][target]==1;
        }
        boolean notTake = helper(n - 1, target, arr);//not take the element
        boolean take = false;
        if(target>=arr[n]){
            take = helper(n - 1, target - arr[n], arr);//take the element
        }
        dp[n][target]= (take || notTake)?1:0;
        return take || notTake;
    }
}
