package com.array2D;

import java.util.Arrays;

public class Rowcolsorted {
    public static void main(String[] args) {
      int[][] arr = {{10,20,30,40},
                     {15,25,35,45},
                     {28,29,37,49},
                     {33,34,38,50}
      };


        System.out.println(Arrays.toString(rowSearch(arr,37)));
    }
    static int[] rowSearch(int[][] arr, int target) {
        int row = 0;
        int col = arr[0].length - 1; // Start from the top-right corner

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return new int[]{row, col};
            }
            if (arr[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return new int[]{-1, -1};
    }
}
