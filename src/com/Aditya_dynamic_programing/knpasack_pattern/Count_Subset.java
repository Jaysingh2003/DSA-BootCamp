package com.Aditya_dynamic_programing.knpasack_pattern;

/// in this question be have to count taha how maney subset is there whose sum is equal to the give sum
public class Count_Subset {
    public int countsubset(int[] arr, int sum){
        int n = arr.length;

        int[][] dp= new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(i == 0){
                    dp[i][j] = 0;
                }
                if(j == 0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] <= j){//arr[i-1]<j  it means arrey ka pahla element me se subtract karenege
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];

    }
}
