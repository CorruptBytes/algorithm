package com.example.y2026.m01.day22;

/**
 * <h1>最小路径和</h1>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class P64 {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        bfs(grid,0,0,0);
        return min;
    }
    //bfs超时
    public void bfs(int[][] grid, int i, int j,int sum) {
        if (i > grid.length - 1 || j > grid[0].length -1) {
            return;
        }
        sum += grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            min = Math.min(min,sum);
            return;
        }
        bfs(grid,i+ 1,j,sum);
        bfs(grid,i,j + 1,sum);
    }

    //动态规划
    public int minPathSumV1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        //初始化dp数组
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0]  + grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }
    //空间优化
    public int minPathSumV2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[] dp = new int[column];
        dp[0] = grid[0][0];
        //初始化dp数组
        for (int i = 1; i < column; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < column; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) +  grid[i][j];
            }
        }
            return dp[column - 1];
    }
}
