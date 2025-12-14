package com.dynamicprograming;


public class Ninja_training {//https://leetcode.com/problems/paint-house-ii/description/
    public static int maxpoint( int day, int last, int[][] points, int[][] dp){

        if(day == 0){//base case where there is not started the traing
            int best=0;
            for(int task=0; task<3; task++){
                if(task!=last){
                    best=Math.max(best,points[0][task]);
                }
            }
            return best;
        }
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        int best=0;
        for(int task=0; task<3; task++){
            if(task == last){
                continue;
            }
            int score= points[day][task] + maxpoint(day-1, task, points, dp);
            best=Math.max(best,score);

        }
        dp[day][last]=best;
        return best;


    }
    public static void main(String[] args) {
        int[][] points = {
                {10, 50, 1},
                {5, 100, 11},
                {20, 30, 40}
        };
        int n = points.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) dp[i][j] = -1;
        }

        int answer = maxpoint(n - 1, 3, points, dp); // last=3 => no restriction on last day
        System.out.println(answer); // expected: 150 (choose 50, 100, ? check input)
    }
}


