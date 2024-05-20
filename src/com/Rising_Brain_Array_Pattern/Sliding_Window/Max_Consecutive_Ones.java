package com.Rising_Brain_Array_Pattern.Sliding_Window;

//https://leetcode.com/problems/max-consecutive-ones/submissions/2052890973/
public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int current_count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current_count++;
            } else {/// this case when we get the zero so we start count from next pointer when we found the one
                max_count = Math.max(max_count, current_count);
                current_count = 0;
            }
        }///we agin update the maxcount we there is posibilty  zero ke bad wale me more 1 aye ho
        return Math.max(max_count, current_count);
    }

    public static void main(String[] args) {
        Max_Consecutive_Ones m=new Max_Consecutive_Ones();
        int arr[]={1,1,1,1,0,1,1,1};
        System.out.println(m.findMaxConsecutiveOnes(arr));
    }
}
