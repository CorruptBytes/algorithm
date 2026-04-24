package com.example.y2026.m02.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>矩阵置零</h1>
 * <p>给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。</p>
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/description/">链接</a>
 */
public class P73 {
    // 空间复杂度O(m + n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = true;
                    column[i] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (row[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < n; j++) {
            if (column[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    //空间复杂度O(1)
    public void setZeroesV1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) flag1 = 1;
                    if (j == 0) flag2 = 1;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flag1 == 1) {
            Arrays.fill(matrix[0],0);
        }
        if (flag2 == 1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int size = m * n;
        int top = 0,bottom = m - 1,left = 0,right = n - 1;
        while (res.size() < size) {
            if (top == bottom && left == right) res.add(matrix[left][left]);
            for (int i = left; i < right && res.size() < size; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top; i < bottom && res.size() < size; i++) {
                res.add(matrix[i][right]);
            }

            for (int i = right; i > left && res.size() < size; i--) {
                res.add(matrix[bottom][i]);
            }

            for (int i = bottom; i > top && res.size() < size; i--) {
                res.add(matrix[i][left]);
            }
            top++;
            right--;
            left++;
            bottom--;
        }
        return res;
    }
}
