package com.Recursion_Backtracking;

public class QueenProblem {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        queen(board, 0);
        System.out.println( queen(board, 0));

    }

    static int queen(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);//at the end of the board
            System.out.println();
            return 1;
        }
        int count = 0;
        //placing the queen and checking for every column in that row and column
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;//placing the queen
                count += queen(board, row + 1);//calling for the next row
                board[row][col] = false;//backtracking step
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        //vertical up
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        //diagonal left up
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {//row and col both decrease
                return false;
            }
        }
        //diagonal right up
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {//row decreases and col increases
                return false;
            }
        }

        return true;//if none of the above return false then it is safe to place the queen
    }


    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {//for each element in the row
                if (element) {//if true means the element is a queen
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
