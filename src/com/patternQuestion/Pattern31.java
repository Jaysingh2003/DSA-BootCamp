package com.patternQuestion;

public class Pattern31 {
    public static void main(String[] args) {
        pattern31(4);
    }

    private static void pattern31(int n) {
        int originalN = n;
        n = 2 * n;

        for (int row=0; row<=n; row++){
            for( int col=0;  col<=n; col++){
              //prin tat every index value;
                int ateveryindex = originalN - Math.min(Math.min(row, col), Math.min(n - row , n - col));
                System.out.print(ateveryindex + " ");
            }
            System.out.println();
        }
    }


}
/*
output:
4 4 4 4 4 4 4 4 4
4 3 3 3 3 3 3 3 4
4 3 2 2 2 2 2 3 4
4 3 2 1 1 1 2 3 4
4 3 2 1 0 1 2 3 4
4 3 2 1 1 1 2 3 4
4 3 2 2 2 2 2 3 4
4 3 3 3 3 3 3 3 4
4 4 4 4 4 4 4 4 4

 */