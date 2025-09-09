package com.Recursion_Backtracking;

import java.util.Arrays;

public class Backtracking_maze {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        mazebacktracking("", maze, 0, 0);
        int[][] path = new int[maze.length][maze[0].length];
        System.out.println("All the path in matrix form");
        allPathPrint("", maze, 0, 0, path, 1);

    }
    static  void mazebacktracking(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {//is it is last cell
            System.out.println(p);
            return;
        }
        if ((!maze[r][c])) {//by default boolean  is false  this block is true so it is alredy visited
            return;
        }
        maze[r][c] = false;// iam considering it that cell is in my path so mark as false

        if (r < maze.length - 1) {//down
            mazebacktracking(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {//right
            mazebacktracking(p + 'R', maze, r, c + 1);
        }
        if (r > 0) {//up
            mazebacktracking(p + 'U', maze, r - 1, c);
        }
        if (c > 0) {//left
            mazebacktracking(p + 'L', maze, r, c - 1);

    }
        //thius line hen this get over then we have to make it true for the next step
        //so before the fxn get over we have to remove the chnages made by the fxn
        maze[r][c] = true;//unmark as visited for other path
    }
//all the path are printed in matrix from
    static  void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int steps) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {//is it is last cell
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            return;
        }
        if ((!maze[r][c])) {//by default boolean  is false  this block is true so it is alredy visited
            return;
        }
        maze[r][c] = false;// iam considering it that cell is in my path so mark as false

        path[r][c] = steps;//this will mark the steps in the matrix
        //print the path matrix

        if (r < maze.length - 1) {//down
            allPathPrint(p + 'D', maze, r + 1, c, path, steps + 1);//at everystep we have to increase the step by 1
        }
        if (c < maze[0].length - 1) {//right
            allPathPrint(p + 'R', maze, r, c + 1, path, steps + 1);
        }
        if (r > 0) {//up
            allPathPrint(p + 'U', maze, r - 1, c, path, steps + 1);
        }
        if (c > 0) {//left
            allPathPrint(p + 'L', maze, r, c - 1, path, steps + 1);

        }
        //thius line hen this get over then we have to make it true for the next step
        //so before the fxn get over we have to remove the chnages made by the fxn
        maze[r][c] = true;//unmark as visited for other path
        path[r][c] = 0;//backtracking step
    }

}
