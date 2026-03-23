package com.example.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class P54 {

    //按照一圈一圈遍历数组。
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length, columns = matrix[0].length;
        List<Integer> result = new ArrayList<>(rows * columns);
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
}
