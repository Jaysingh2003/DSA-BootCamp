package com.TWOPOINTER.variablesize;
//The questionn isthat we have to find the longest subsequence length whose sum is equal to k



/// this is valid only for positive numbers only
public class Longest_subsequence {
    public static int LogestSubsequence(int[] arr, int k) {
        int i = 0, j = 0;
        int sum = 0;
        int maxLength = 0;
        int n = arr.length;

        while (j < n) {
            sum += arr[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else {
                while (sum > k && i <= j) {
                    sum -= arr[i];
                    i++;

                }
                j++;

            }
        }
        return maxLength;

    }

    /// its is valid for all the numbers positive and negative both
    public static int LongestSubsequenceAll(int[] arr, int k) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
        }
        return maxLength;
    }
}
