package com.example.day49;

/**
 * <h1>腐烂的橘子</h1>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class P994 {

    public int orangesRotting(int[][] grid) {
        boolean change = false;
        int row = grid.length;
        int column = grid[0].length;
        int ans = 0;
        while (true) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j] == 2) {
                        if (i - 1 != -1 && grid[i - 1][j] == 1)
                            grid[i - 1][j] = 3;
                        if (i + 1 != row && grid[i + 1][j] == 1)
                            grid[i + 1][j] = 3;
                        if (j - 1 != -1 && grid[i][j - 1] == 1)
                            grid[i][j - 1] = 3;
                        if (j + 1 != column && grid[i][j + 1] == 1)
                            grid[i][j + 1] = 3;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                        change = true;
                    }
                }
            }
            if (!change) {
                break;
            }
            change = false;
            ans++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
