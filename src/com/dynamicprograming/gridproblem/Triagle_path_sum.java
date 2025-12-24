package com.dynamicprograming.gridproblem;

import java.util.Arrays;

//yoiu can mpove to down or down+right and find the minimum path sum from top to bottom (down and diagonally right) possible move
public class Triagle_path_sum {
    int[][] dp;

    public int minimumumTotal(int[][] triangle) {

        int rows = triangle.length;
        int col = triangle[rows - 1].length;
        dp = new int[rows][col];
        for (int i = 0; i < col; i++) {
            Arrays.fill(dp[i], -1);
        }
       return helper(0,0,triangle);
    }
    private int helper(int r, int c, int[][] triangle) {
        if(r==triangle.length-1) return  triangle[r][c];//base case when we reach the last row we return the value at that position
        if(dp[r][c]!=-1) return dp[r][c];//if we have already calculated the minimum path sum for this cell return it
        int down = triangle[r][c] + helper(r + 1, c, triangle);//move down
        int diagonal = triangle[r][c] + helper(r + 1, c + 1, triangle);//move diagonally right
        return dp[r][c] = Math.min(down, diagonal);//store the minimum path sum for this cell in dp array and return
    }

    public static void main(String[] args) {
        Triagle_path_sum obj = new Triagle_path_sum();
        int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        int result = obj.minimumumTotal(triangle);
        System.out.println("Minimum path sum from top to bottom: " + result);
    }

}
