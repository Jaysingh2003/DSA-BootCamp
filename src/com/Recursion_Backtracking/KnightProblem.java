package com.Recursion_Backtracking;

public class KnightProblem {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
       int ans = knightTour(board, 0, 0, 4);
         System.out.println(ans);


    }

    static int knightTour(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {///if no knights left to place
            display(board);
            System.out.println();
            return 1;
        }

        if (row == board.length - 1 && col == board.length) {//if row and col reaches end of the board the skip it
            return 0;
        }

        if (col == board.length) {//if col reaches end of the board
            return knightTour(board, row + 1, 0, knights);//move to next row and reset col to 0

        }
      int count = 0;
        if (issafe(board, row, col)) {
            board[row][col] = true;//place the knight
             count += knightTour(board, row, col + 1, knights - 1);//move to next col and reduce knights by 1
            board[row][col] = false;//backtracking step
        }
        count += knightTour(board, row, col + 1, knights);//not placing the knight and moving to
        return count;

    }

    static boolean issafe(boolean[][] board, int row, int col) {

        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;//if none of the above return false then it is safe to place the knight
    }

    // check if the position is within the board
    //everytime we have to check this candition hece we created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {//for each element in the row
                if (element) {//if true means the element is a queen
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
