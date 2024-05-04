package com.Aditya_dynamic_programing.Matrix_chain_multiplication;

public class Palindrome_Partitioning_Recursive{
    public int minCut(String s) {
        return solve(s, 0, s.length() - 1);
    }

   int solve(String s, int i, int j) {
        // Base case
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // Try all partitions
        for (int k = i; k < j; k++) {

            int left = solve(s, i, k);
            int right = solve(s, k + 1, j);

            int cuts = left + right + 1;

            min = Math.min(min, cuts);
        }

        return min;
    }

  boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

//add 4 line to mke it  memoization
// Add a memoization table to store results of subproblems