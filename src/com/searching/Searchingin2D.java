package com.searching;

import java.util.Arrays;

public class Searchingin2D {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 6, 7},
                {8, 9, 20, 23, 56},
                {4, 6, 4, 3, 76, 44, 67}
        };
        int target = 44;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[] {row, col};//here we inialize the arrya becuse it dod not initislixe  anywhere
                }
            }
        }
        return new int[] {-1, -1}; // If not found
    }
}