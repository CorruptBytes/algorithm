package com.example.y2026.m01.day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>岛屿数量</h1>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class P200 {

    //深度优先搜索，找到所有相连的1，并将其置为0
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                dfs(grid,i,j);
                count++;
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid,i - 1,j);
        dfs(grid,i + 1,j);
        dfs(grid,i,j - 1);
        dfs(grid,i, j + 1);
    }


}
