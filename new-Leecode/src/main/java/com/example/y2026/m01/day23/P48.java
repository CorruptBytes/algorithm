package com.example.y2026.m01.day23;
/**<h1>旋转图像</h1>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class P48 {

    //先将每行两两交换，再沿对角线交换.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int[] temp = matrix[l];
            matrix[l++] = matrix[r];
            matrix[r--] = temp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
