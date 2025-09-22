package com.test;

public class ArrayTransform {
    /**
     * Computes the minimum number of split/merge operations required to transform nums1 into nums2
     * assuming both arrays are of the same length and composed of the same multiset of values.
     * The minimum number of operations equals n - LCS(nums1, nums2).
     *
     * @param nums1 first array
     * @param nums2 second array
     * @return minimum operations to transform nums1 to nums2
     * @throws IllegalArgumentException if arrays are null or have different lengths
     */
    public int minSplitMerge(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Input arrays must not be null");
        }
        if (nums1.length != nums2.length) {
            throw new IllegalArgumentException("Input arrays must have the same length");
        }
        int n = nums1.length;
        if (n == 0) return 0;
        int lcs = longestCommonSubsequence(nums1, nums2);
        return n - lcs;
    }

    // Space-optimized LCS for two integer arrays of equal length
    private int longestCommonSubsequence(int[] a, int[] b) {
        int n = a.length;
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= n; i++) {
            int cur = i & 1;
            int prev = cur ^ 1;
            // reset current row's first column
            dp[cur][0] = 0;
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[cur][j] = dp[prev][j - 1] + 1;
                } else {
                    dp[cur][j] = Math.max(dp[prev][j], dp[cur][j - 1]);
                }
            }
        }
        return dp[n & 1][n];
    }
}
