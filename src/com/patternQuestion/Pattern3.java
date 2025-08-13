package com.patternQuestion;


/*
patter3
 * * * * *
 * * * *
 * * *
 * *
 *
petten4
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5


 */
public class Pattern3 {
    public static void main(String[] args) {
        pattern3(5);
        pattern4(5);
    }

    private static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col<= n-row+1; col++) {
                System.out.print("* ");
            }
            // Print a new line after each row
            System.out.println();
        }
    }

    private static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col<= row; col++) {
                System.out.print(col+" ");
            }
            // Print a new line after each row
            System.out.println();
        }
    }

}
