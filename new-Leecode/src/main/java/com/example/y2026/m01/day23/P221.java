package com.example.y2026.m01.day23;
/**
 * <h1>最大正方形</h1>
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class P221 {

    //暴力遍历
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int max = 0;
        //遍历矩阵中的每个元素，每次遇到 1，则将该元素作为正方形的左上角；
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max,1);
                    int currentMaxSide = Math.min(rows - i,columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            max = Math.max(k + 1,max);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return max * max;
    }
    //动态规划
    public int maximalSquareV1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        //dp(i, j) 是以 matrix(i, j) 为右下角的正方形的最大边长
        int[][] dp = new int[rows][columns];
        int maxSide = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                }
                maxSide = Math.max(maxSide,dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
