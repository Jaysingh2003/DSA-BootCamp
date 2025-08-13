package com.patternQuestion;

public class Pattern28 {
    public static void main(String[] args) {
        pattern28(5);
    }
    static void pattern28(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row  : row;// turnery operator Calculate the number of columns in the current row

            int spaces = n - totalColsInRow; // Calculate leading spaces for centering the pattern
            for (int s = 0; s < spaces; s++) {
                System.out.print(" "); // Print leading spaces
            }
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");// Print the star
                // Print a new line after each row
            }
            System.out.println();
        }

    }
}
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