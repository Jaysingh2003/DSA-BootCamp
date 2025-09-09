package com.Recursion_Backtracking;

import java.util.ArrayList;

public class Maze{
    public static void main(String[] args) {
        //count paths
        System.out.println(count(3,3));
        //print paths
         printPath("",3,3);
         //list of paths
        System.out.println(listPath("",3,3));
        //when diagonal is also included
        System.out.println(diagonal_Incl_Path("",3,3));
        //maze with restriction
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        mazerestriction("", maze, 0, 0);

    }
    static int count(int r, int c){
        if(r==1 | c==1){
           return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }

    //print paths
    static void printPath( String p,int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            printPath(p + 'D', r - 1, c);
        }
        if (c > 1) {
            printPath(p + 'R', r, c - 1);
        }
    }


    static ArrayList<String> listPath(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();//it is a local list to store all the paths
        if (r > 1) {                               //list will we return from where is called
            ans.addAll(listPath(p + 'D', r - 1, c));
        }
        if (c > 1) {
            ans.addAll(listPath(p + 'R', r, c - 1));
        }
      return ans;
    }

    static ArrayList<String> diagonal_Incl_Path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();//it is a local list to store all the paths
        if (r > 1) {                               //list will we return from where is called
            ans.addAll(diagonal_Incl_Path(p + 'V', r - 1, c));
        }
        if (c > 1) {
            ans.addAll(diagonal_Incl_Path(p + 'H', r, c - 1));
        }
        //diagonal
        if (r > 1 && c>1) {                               //list will we return from where is called
            ans.addAll(diagonal_Incl_Path(p + 'D', r - 1, c));
        }
        return ans;
    }

    //maze with restriction
    //if it is false we cannot go that way
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
