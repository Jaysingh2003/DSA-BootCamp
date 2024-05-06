package com.Aditya_dynamic_programing.lcs_Problem;

/// Minimum number of insertion in a string to make it a palindrome
/// but its give that only one string and we need two string for the lcs so what we do we take the revese of the
/// string 1 so by these ways the we try to find the lcs
/// idea :- the string1 and string2 have the commnon charecter at the same position and this letter will come in the lcs
///
public class insertion_to_make_it_a_palindrome {
public int lcsInsertion(String s1) {
    String s2 = new StringBuilder(s1).reverse().toString();
    int m = s1.length();
    int n = s2.length();
    int[][] dp = new int[m+1][n+1];

    for(int i = 0; i <= m; i++){
        dp[i][0] = 0;

    }
    for(int i = 0; i <= n; i++){
        dp[0][i] = 0;
    }
    for(int i = 1; i <= m; i++){
        for(int j = 1; j <= n; j++){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1]+1;
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    return m - dp[m][n];
}
}
