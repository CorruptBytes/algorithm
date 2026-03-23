package com.example.y2026.m02.day27;

import java.util.Arrays;

/**
 * <h1>被围绕的区域</h1>
 * <p>给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果一个区域中的所有 'O' 单元格都不在棋盘的边缘，则该区域被包围。这样的区域 完全 被 'X' 单元格包围。
 * 通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。</p>
 */
public class P130 {

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] used = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!dfs(i,j,board,used)) {
                    fill(i,j,board);
                }
                for (int k = 0; k < n; k++) {
                    Arrays.fill(used[k],false);
                }
            }
        }
    }
    public boolean dfs(int i, int j, char[][] board,boolean[][] used) {
        if (i < 0 ||i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == 'X' || used[i][j]) return true;
        used[i][j] = true;
        return dfs(i + 1,j,board,used) && dfs(i - 1,j,board,used) && dfs(i,j + 1,board,used) && dfs(i,j - 1,board,used);
    }
    public void fill(int i, int j, char[][] board) {
        if (i < 0 ||i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' ) return;
        board[i][j] = 'X';
        fill(i - 1,j,board);
        fill(i + 1,j,board);
        fill(i,j - 1,board);
        fill(i,j + 1,board);

    }
}
