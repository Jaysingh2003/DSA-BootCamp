package com.Aditya_dynamic_programing.knpasack_pattern;

public class Count_number_of_subset_with_a_given_difference {

    //we hav to solve it in two parts
    //1- first e have to count the sum1
    //2- after that we have to find the count of total subset from the subset sum problem.
    public static int countSum(int[] arr, int diff) {
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        // Edge cases if the odd no is then int is not possible to divide it into two part and if the diff is greater than sum
        // then also it is not possible to divide it into two part
        if ((diff + sum) % 2 != 0 || diff > sum) {
            return 0;
        }
       int Sums1=(diff+sum)/2;///se the formula from the notes how it drive
         return countSubset(arr, Sums1);
    }
    public static int countSubset(int[] arr, int sum){
        int n= arr.length;

        int[][] dp= new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {/// first we have to go upto n fro zero dhayan se dekho
            dp[i][0] = 1;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }


        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= sum; j++){
               if(arr[i-1] <= j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
