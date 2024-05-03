package com.Aditya_dynamic_programing.Matrix_chain_multiplication;

///
/// Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
/// The given expression is "T ^ F & T", it evaluates true
/// in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
public class Evaluate_Expression_to_True_Recursive {

    public static int countWays(String s) {
        // write your code here
        int i = 0;
        int j = s.length() - 1;
        return solve(s, i, j, true);
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

        return ans;
    }
}

