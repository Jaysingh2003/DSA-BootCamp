package com.Aditya_dynamic_programing.Matrix_chain_multiplication;

/// Given a sequence of matrices, find the most efficient way to multiply these matrices together.
///  The problem is not actually to  perform the multiplications, but merely to decide in which order to perform the multiplications.
public class Matrix_chain_multiplication_Recursive {

    public int mcm(int[] arr) {
        int i = 1;
        int j = arr.length - 1;
        return solve(arr, i, j);
    }

    public int solve(int[] arr, int i, int j) {
        if(i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k < j; k++) {
            int temp = solve(arr, i, k)
                    + solve(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j]; // ✅ correct

            min = Math.min(min, temp);
        }

        return min;
    }
}
