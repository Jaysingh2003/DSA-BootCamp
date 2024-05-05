package com.Aditya_dynamic_programing.knpasack_pattern;

//in this we have to nfind the maximum profit.
//memoization for topdown approch
public class Zero_One_knapsack {
        int[][] dp;
        int knapsack(int[] value, int[] weight, int capacity, int n){

            if(n == 0 || capacity == 0){
                return 0;
            }
            if(dp[n][capacity] != -1){
                return dp[n][capacity];
            }
            if(weight[n-1] <= capacity){
                dp[n][capacity] = Math.max(
                        value[n-1] + knapsack(value, weight, capacity - weight[n-1], n-1),
                        knapsack(value, weight, capacity, n-1)
                );
            }
            else{
                dp[n][capacity] = knapsack(value, weight, capacity, n-1);
            }
            return dp[n][capacity];
        }

        /// coversion int tabulation

    int knapsack_tabulation(int[] value, int[] weight, int capacity, int n){
            int[][] dp = new int[n+1][capacity+1];

            for (int i = 0; i <=n ; i++) {
                for (int j = 0; j <=capacity ; j++) {
                    if(i == 0 || j == 0){
                        dp[i][j] = 0;
                    }
                    ///    •	weight[i-1] → weight of the current item
                    /// 	•	j → remaining capacity
                    else if(weight[i-1] <= j){//this condition will chack where the item weight is less that the the currrent space of the bag if yes then we have two choices
                        dp[i][j] = Math.max(/// Can I place this item in the remaining bag space?
                                value[i-1] + dp[i-1][j-weight[i-1]],
                                dp[i-1][j]
                        );
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][capacity];
        }
}
