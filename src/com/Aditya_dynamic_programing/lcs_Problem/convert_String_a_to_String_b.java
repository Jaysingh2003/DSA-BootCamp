package com.Aditya_dynamic_programing.lcs_Problem;


/// in this question we have to convert the string a into strin we b by the insertuin and deletion of charecter
/// and retun the no of operation in this question
public class convert_String_a_to_String_b {
    public int lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = 0;

        }
        for(int i = 0; i <= n; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];

    }
    //now we will use these length to find the deletionand insertion
    public int aToB(String a, String b){
        int lcsLength = lcs(a, b);
        int deletions = a.length() - lcsLength;
        int insertions = b.length() - lcsLength;
        return deletions + insertions;
    }

}
