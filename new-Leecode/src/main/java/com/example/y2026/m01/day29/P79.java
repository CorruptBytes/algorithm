package com.example.y2026.m01.day29;
/**
 * <h1>单词搜索</h1>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class P79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, used, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word,boolean[][] used, int index,int i, int j) {
        if (index == word.length()) return true;
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || used[i][j] || word.charAt(index) != board[i][j]) return false;
        used[i][j] = true;
        boolean flag1 = dfs(board,word,used,index + 1,i + 1,j);
        boolean flag2 = dfs(board,word,used,index + 1,i - 1,j);
        boolean flag3 = dfs(board,word,used,index + 1,i,j + 1);
        boolean flag4 = dfs(board,word,used,index + 1,i,j - 1);
        used[i][j] = false;
        return flag1 || flag2 || flag3 || flag4;
    }
}
