package com.example.day39;

/**
 * <h1>单词搜索</h1>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class P79 {
    //dfs + 回溯?
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int rows = board.length;
        int columns = board[0].length;
        byte[][] flag = new byte[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (dfs(word,board,flag,0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(String word,char[][] board,byte[][] flag, int index,int row,int column) {
        if (index == word.length()) {
            return true;
        }
        int rows = board.length;
        int columns = board[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns || flag[row][column] == 1) {
            return false;
        }
        if (word.charAt(index) != board[row][column]) {
            return false;
        }
        flag[row][column] = 1;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        flag1 = dfs(word,board,flag,index + 1,row + 1,column);
        flag2 = dfs(word,board,flag,index + 1,row - 1,column);
        flag3 = dfs(word,board,flag,index + 1,row,column + 1);
        flag4 = dfs(word,board,flag,index + 1,row,column - 1);
        flag[row][column] = 0;
        return flag1 || flag2 || flag3 || flag4;
    }

//    public boolean dfs(String word,char[][] board,int[][] flag, int index,int row,int column) {
//        if (index == word.length()) {
//            return true;
//        }
//        int rows = board.length;
//        int columns = board[0].length;
//        if (word.charAt(index) != board[row][column]) {
//            return false;
//        }
//        flag[row][column] = 1;
//        boolean flag1 = false;
//        boolean flag2 = false;
//        boolean flag3 = false;
//        boolean flag4 = false;
//        if (!(row + 1 < 0 || row + 1 >= rows || column < 0 || column >= columns || flag[row + 1][column] == 1)) {
//            flag1 =  dfs(word,board,flag,index + 1,row + 1,column);
//            flag[row + 1][column] = 0;
//        }
//        if (!(row - 1 < 0 || row - 1 >= rows || column < 0 || column >= columns || flag[row - 1][column] == 1)) {
//            flag2 =  dfs(word,board,flag,index + 1,row - 1,column);
//            flag[row - 1][column] = 0;
//        }
//        if (!(row < 0 || row >= rows || column + 1 < 0 || column + 1 >= columns || flag[row][column + 1] == 1)) {
//            flag3 =  dfs(word,board,flag,index + 1,row,column + 1);
//            flag[row][column + 1] = 0;
//        }
//        if (!(row < 0 || row >= rows || column - 1 < 0 || column - 1 >= columns || flag[row][column - 1] == 1)) {
//            flag4 =  dfs(word,board,flag,index + 1,row,column - 1);
//            flag[row][column - 1] = 0;
//        }
//        return flag1 || flag2 || flag3 || flag4;
//    }
}
