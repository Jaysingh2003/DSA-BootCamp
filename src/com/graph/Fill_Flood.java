package com.graph;


/// https://leetcode.com/problems/flood-fill/description/
public class Fill_Flood {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // ///think like the bfs graph but we don't need to take the visited node  to tracek what we can    do we simply check and chnage its vakue ;
        if (originalColor == color) return image;

        dfs(image, sr, sc, color, originalColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int newColor, int originalColor) {

        // Boundary + color checks
        if (r < 0 || c < 0 ||
                r >= image.length || c >= image[0].length ||
                image[r][c] != originalColor) {
            return;
        }

        // Change color (acts like visited)
        image[r][c] = newColor;

        // 4-direction DFS
        dfs(image, r - 1, c, newColor, originalColor); // top
        dfs(image, r, c + 1, newColor, originalColor); // right
        dfs(image, r + 1, c, newColor, originalColor); // bottom
        dfs(image, r, c - 1, newColor, originalColor); // left
    }
}
