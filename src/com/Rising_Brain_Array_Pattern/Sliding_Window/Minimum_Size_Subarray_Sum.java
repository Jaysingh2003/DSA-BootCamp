package com.Rising_Brain_Array_Pattern.Sliding_Window;


/// this is the brute force approach
public class Minimum_Size_Subarray_Sum {
    public int minLengthSubarray(int[] arr, int k) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;///we asume that the length is maximuum intially

        for (int i = 0; i < n; i++) {
            int sum = 0;/// because we have to calculate the sum again if the i will change that is why
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > k) {
                    int length = j - i + 1;/// length of the substring
                    ans = Math.min(ans, length);
                    break;///after that we calcuate the the sum again from the next index of i
                }
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /// this is the optimal approach using the sliding window technique variable size

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) ///its a valid condition so we calculate its length  and the
                min = Math.min(min, j - i + 1);
            sum -= nums[i];
            i++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }
}

