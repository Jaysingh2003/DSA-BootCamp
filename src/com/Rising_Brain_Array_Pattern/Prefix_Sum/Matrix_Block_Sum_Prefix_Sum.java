package com.Rising_Brain_Array_Pattern.Prefix_Sum;


///
/// Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j]
///  is the sum of all elements mat[r][c] for:
///
/// i - k <= r <= i + k,
/// j - k <= c <= j + k, and
/// (r, c) is a valid position in the matrix.
public class Matrix_Block_Sum_Prefix_Sum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] prefixSum = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {/// prefixSum[i-1][j-1] we sibtracte this part becaouse it conut two times
                prefixSum[i][j] = mat[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int r1 = Math.max(0, i - k);/// if i-k<0 then r1=0 else r1=i-k ///left side boundry ke andar hi rahe
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(r - 1, i + k);/// if i+k>r-1 then r2=r-1 else r2=i+k
                int c2 = Math.min(c - 1, j + k);
                r1++;
                r2++;
                c1++;
                c2++;

                result[i][j] = prefixSum[r2 + 1][c2 + 1]
                        - prefixSum[r1][c2 + 1]
                        - prefixSum[r2 + 1][c1]
                        + prefixSum[r1][c1];
            }
        }
        return result;

    }

}
