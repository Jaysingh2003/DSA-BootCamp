package com.patternQuestion;

public class pattern5 {
    public static void main(String[] args) {
        pattern5(5);
    }

    static void pattern5(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row  : row;// turnery operator Calculate the number of columns in the current row
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");// Print the star
                // Print a new line after each row
            }
            System.out.println();
        }

    }
}

// Output:
/*

 *
 * *
 * * *
 * * * *
 * * * * *
 * * * *
 * * *
 * *
 *

 */

/*        long way
    private static void pattern5(int n) {
        for (int row = 0; row < 2 * n; row++) {
           for( int col =1; col<= n; col++) {
               if (row < n) {
                   // Upper half
                   if (col <= row + 1) {
                       System.out.print("* ");
                   } else {
                       System.out.print("  ");
                   }
               } else {
                   // Lower half
                   if (col <= 2 * n - row - 1) {
                       System.out.print("* ");
                   } else {
                       System.out.print("  ");
                   }
               }
           }
           // Print a new line after each row
           System.out.println();
        }
    }
*/