package com.Rising_Brain_Array_Pattern.Sliding_Window;

///https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int window = 0;///it will count the sum
        int n = nums.length;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            window += nums[right];
            while (window + k < right - left + 1) {///in this we use the sum concept like if the toatalsum + k  is grater than
            ///window size then we have to shrink the window  like  sare one rahne par bhi sum us se jyada to nahi hoga
                window -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /// another approach
    public int longestOnesII(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int n = nums.length;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {///we will use the while loof becouse we dont know how many zero we should remove from the left side
                if (nums[left] == 0) {
                    zeros--;///zero ka count kama do
                }
                left++;///and  left pointer ko ek age badha do
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Max_Consecutive_Ones_III m = new Max_Consecutive_Ones_III();
        int arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(m.longestOnes(arr, 3));
    }


}
