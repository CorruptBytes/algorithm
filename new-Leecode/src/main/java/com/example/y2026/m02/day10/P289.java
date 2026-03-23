package com.example.y2026.m02.day10;

/**
 * <h1>生命游戏</h1>
 * <p>根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
 * 其中细胞的出生和死亡是 同时 发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * 给定当前 board 的状态，更新 board 到下一个状态。
 * 注意 你不需要返回任何东西</p>
 * <a href="https://leetcode.cn/problems/game-of-life/description">链接</a>
 */
public class P289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = update(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2) board[i][j] = -1;
                    else if (count > 3) board[i][j] = -1;
                } else {
                    if (count == 3) board[i][j] = -2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == -2) board[i][j] = 1;
            }
        }
    }

    private int update(int[][] board, int i, int j) {
        int res = count(board, i - 1, j - 1);
        res += count(board,i - 1, j);
        res += count(board,i - 1, j + 1);
        res += count(board,i, j - 1);
        res += count(board,i, j + 1);
        res += count(board,i + 1, j - 1);
        res += count(board,i + 1,j);
        res += count(board,i + 1, j + 1);
        return res;
    }
    private int count(int[][] board,int i ,int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0 || board[i][j] == -2){
            return 0;
        }
        return 1;
    }
}
