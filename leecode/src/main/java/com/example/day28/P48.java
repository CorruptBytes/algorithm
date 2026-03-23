package com.example.day28;

import java.util.Arrays;

/**<h1>旋转图像</h1>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class P48 {
    /*
    转九十度即为将行变成列，列变成行
    感觉可以先以对角线为对称轴交换元素，然后翻转矩阵的列。
    但是矩阵的列没法连续访问啊，翻转起来比较麻烦
    可以以逆对角线为对称轴交换元素，翻转矩阵的行貌似也可以达到效果
    怎么以逆对角线为对称轴交换元素？奶奶的想不出来，应该下标会有规律，画个图看看
     */
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - j - 1][column - i - 1];
                matrix[row - j - 1][column - i - 1] = temp;
            }
        }
        for (int i = 0; i < row / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[row - i - 1];
            matrix[row - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        P48 test = new P48();
        test.rotate(matrix);
        for (int[] ints : matrix) {
            Arrays.stream(ints).forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
