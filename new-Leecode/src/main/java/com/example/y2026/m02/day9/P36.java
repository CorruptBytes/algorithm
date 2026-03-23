package com.example.y2026.m02.day9;

import java.util.Arrays;

/**
 * <h1>有效的数独</h1>
 * <p>请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）</p>
 * <a href="https://leetcode.cn/problems/valid-sudoku/description">链接</a>
 */
public class P36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] columns = new int[9][9];
        int[][] squares = new int[9][9];
        int[] row = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int index = (i / 3) * 3 + (j / 3);
                if (c != '.') {
                    if (row[c - '1'] != 0 || columns[j][c - '1'] != 0 || squares[index][c - '1'] != 0) {
                        return false;
                    } else {
                        row[c - '1'] = 1;
                        columns[j][c - '1'] = 1;
                        squares[index][c - '1'] = 1;
                    }
                }
            }
            Arrays.fill(row,0);
        }
        return true;
    }
}
