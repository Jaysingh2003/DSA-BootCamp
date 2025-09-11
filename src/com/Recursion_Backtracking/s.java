package com.Recursion_Backtracking;

public class s {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Solution is not possible");
        }

    }

    //finding the first empty cell in the Sudoku board.
    static boolean solve(int[][] board) {// all 0  are empty cells
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;// its a flag to check if there is any empty cell left
        //if the empty cell is found then we will set it to false
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;//
                    break;// break the inner loop

                }
            }
            //if we found an empty cell in row then we will break the outer loop also
            if (emptyLeft == false) {
                break;
            }
        }
        //if there is no empty cell left then we have solved the Sudoku
        if (emptyLeft == true) {
            return true;
        }

        //backtracking
        for (int number = 1; number <= 9; number++) {
            if (issafe(board, row, col, number)) {//check if it is safe to place the number
                board[row][col] = number;
                if (solve(board)) {//recursive call
                    //found the answer
                    return true;
                } else {
                    board[row][col] = 0;//backtrack
                }
            }
        }
        return false;//this triggers backtracking
    }
    //print the board
    static void display(int[][] board) {
        for (int[] nums : board) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }


    static boolean issafe(int[][] board, int row, int col, int num) {
        //chck row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        for (int[] nums : board) {
            if (nums[col] == num) {
                return false;
            }
        }
        int sqrt = (int) (Math.sqrt(board.length));
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;
        for (int i = startRow; i < startRow + sqrt; i++) {
            for (int j = startCol; j < startCol + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

