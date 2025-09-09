package com.Recursion_Backtracking;

public class Maze_Restriction {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        mazerestriction("", maze, 0, 0);

    }
    static  void mazerestriction(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {//is it is last cell
            System.out.println(p);
            return;
        }
        if ((!maze[r][c])) {//if it is false
            return;
        }
        if (r < maze.length - 1) {//down
            mazerestriction(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {//right
            mazerestriction(p + 'R', maze, r, c + 1);
        }

    }
}
