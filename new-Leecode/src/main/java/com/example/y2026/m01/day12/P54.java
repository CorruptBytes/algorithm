package com.example.y2026.m01.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>螺旋矩阵</h1>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class P54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length, columns = matrix[0].length;
        List<Integer> result = new ArrayList<>(rows * columns);
        //矩阵的四个边界
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (result.size() < rows * columns) {
            //遍历上侧
            for (int column = left; column <= right; column++) {
                if (result.size() == rows * columns) {
                    return result;
                }
                result.add(matrix[top][column]);
            }
            top++;
            //遍历右侧
            for (int row = top; row <= bottom; row++) {
                if (result.size() == rows * columns) {
                    return result;
                }
                result.add(matrix[row][right]);
            }
            right--;
            //遍历下侧
            for (int column = right; column >= left; column--) {
                if (result.size() == rows * columns) {
                    return result;
                }
                result.add(matrix[bottom][column]);
            }
            bottom--;
            //遍历左侧
            for (int row = bottom; row >= top; row--) {
                if (result.size() == rows * columns) {
                    return result;
                }
                result.add(matrix[row][left]);
            }
            left++;
        }
        return result;
    }

    public List<Integer> spiralOrderV1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int circle  = Math.min(m,n) / 2;
        for (int i = 0; i <= circle; i++) {
            //上
            int r = i,c = i;
            while (c < n - i - 1) {
                if (list.size() == m * n) return list;
                list.add(matrix[r][c++]);
            }

            //右
            while (r < m - i - 1) {
                if (list.size() == m * n) return list;
                list.add(matrix[r++][c]);
            }
            //下
            while (c >= i + 1) {
                if (list.size() == m * n) return list;
                list.add(matrix[r][c--]);
            }
            //左
            while (r >= i + 1) {
                if (list.size() == m * n) return list;
                list.add(matrix[r--][c]);
            }
        }
        if (list.size() == m * n) return list;
        if (m == n) list.add(matrix[m / 2][m / 2]);
        return list;
    }
    public List<Integer> spiralOrderV2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int size = m * n;
        int top = 0,bottom = m - 1,left = 0,right = n - 1;
        while (res.size() < size) {

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
