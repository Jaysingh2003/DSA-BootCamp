package com.boutnous_acciolite;

public class Count_Squares {
    public int countSquares(int n) {
        int count = 0;
        for (int i = 1; i * i < n; i++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }


}
