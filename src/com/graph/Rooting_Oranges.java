package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Rooting_Oranges {

    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }


    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // Step 1: push all rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));// push rotten orange with time 0
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;

        /// BFS traversal
        while (!q.isEmpty()) {
            Pair p = q.poll();// remove front pair and process it
            int row = p.row;
            int col = p.col;
            int time = p.time;

            ans = Math.max(ans, time);

            // explore 4 directions
            if (row - 1 >= 0 && !visited[row - 1][col] && grid[row - 1][col] == 1) {// up
                visited[row - 1][col] = true;
                q.offer(new Pair(row - 1, col, time + 1));
            }
            if (col + 1 < m && !visited[row][col + 1] && grid[row][col + 1] == 1) {// right
                visited[row][col + 1] = true;
                q.offer(new Pair(row, col + 1, time + 1));
            }
            if (row + 1 < n && !visited[row + 1][col] && grid[row + 1][col] == 1) {// down
                visited[row + 1][col] = true;
                q.offer(new Pair(row + 1, col, time + 1));
            }
            if (col - 1 >= 0 && !visited[row][col - 1] && grid[row][col - 1] == 1) {// left
                visited[row][col - 1] = true;
                q.offer(new Pair(row, col - 1, time + 1));
            }

        }
        // check if any fresh orange is left means not visited
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return ans;
    }

}
