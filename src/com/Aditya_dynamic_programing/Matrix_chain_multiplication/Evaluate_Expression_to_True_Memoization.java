package com.Aditya_dynamic_programing.Matrix_chain_multiplication;


/// in memoization we will store the value of true and false in 3d array
/// because there are three variable which are changing in this
/// 	•	dp[i][j][1] → ways to make TRUE
/// 	•	dp[i][j][0] → ways to make FALSE
public class Evaluate_Expression_to_True_Memoization {
    static int[][][] dp;///memo-1

    public static int countWays(String s) {

        int n = s.length();
        dp = new int[n][n][2];///memo-2

        // initialize with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(s, 0, n - 1, true);
    }


    public static int solve(String s, int i, int j, boolean T) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (T == true && s.charAt(i) == 'T') {
                return 1;
            } else if (T == false && s.charAt(i) == 'F') {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0;
        int t = T ? 1 : 0;
        if (dp[i][j][t] != -1) {/// memo-3
            return dp[i][j][t];
        }
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lt = solve(s, i, k - 1, true);
            int lf = solve(s, i, k - 1, false);
            int rt = solve(s, k + 1, j, true);
            int rf = solve(s, k + 1, j, false);

            if (s.charAt(k) == '|') {/// anyone is true
                if (T == true) {
                    ans = ans + lt * rt + lt * rf + lf * rt;
                } else {
                    ans = ans + lf * rf;
                }
            }
            if (s.charAt(k) == '&') {/// dono true hona chahiye
                if (T == true) {
                    ans = ans + lt * rt;
                } else {
                    ans = ans + lt * rf + lf * rt + lf * rf;
                }
            }

            if (s.charAt(k) == '^') {/// same par false and opposte par true value ata h
                if (T == true) {
                    ans = ans + lt * rf + lf * rt;
                } else {
                    ans = ans + lt * rt + lf * rf;
                }
            }


        }

        return dp[i][j][t] = ans;///memo4
    }

    public static void main(String[] args) {
        System.out.println(countWays("T|F&T^T"));
    }
}
