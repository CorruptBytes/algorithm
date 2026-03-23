package com.example.y2026.m02.day4;

/**
 * <h1>腐烂的橘子</h1>
 * <p>在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。</p>
 * <a href="https://leetcode.cn/problems/rotting-oranges/description/">链接</a>
 */
public class P994 {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n =grid[0].length;
        while (!allRotting(grid)) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) rotting(grid,i,j);
                }
            }
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 3) {
                        flag = true;
                        grid[i][j] = 2;
                    }
                }
            }
            if (!flag) {
                return -1;
            }
            res++;
        }

        return res;
    }
    private boolean allRotting(int[][] grid) {
        for (int[] row : grid) {
            for (int i : row) {
                if (i == 1) return false;
            }
        }
        return true;
    }
    private void rotting(int[][] grid,int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i + 1 < m && grid[i + 1][j] == 1) grid[i + 1][j] = 3;
        if (i - 1 > -1 && grid[i - 1][j] == 1) grid[i - 1][j] = 3;
        if (j + 1 < n && grid[i][j + 1] == 1) grid[i][j + 1] = 3;
        if (j - 1 > -1 && grid[i][j - 1] == 1) grid[i][j - 1] = 3;
    }
}
