package com.graph;

public class Count_iLands {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        // temporary visited grid
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;                      // new island found
                    dfs(grid, visited, i, j);    // mark whole island
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, boolean[][] visited, int r, int c) {

        // boundary + visited + water check
        if (r < 0 || c < 0 || r >= grid.length ||
                c >= grid[0].length || visited[r][c] || grid[r][c] == '0') {
            return;
        }

        // mark as visited in temp grid
        visited[r][c] = true;

        // explore 4 directions

        dfs(grid, visited, r - 1, c);// up
        dfs(grid, visited, r, c + 1);// right
        dfs(grid, visited, r + 1, c);// down
        dfs(grid, visited, r, c - 1);// left
    }

}
