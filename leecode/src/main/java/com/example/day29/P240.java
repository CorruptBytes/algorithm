package com.example.day29;

/**
 * <h1>搜索二维矩阵Ⅱ</h1>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <li>每行的元素从左到右升序排列。</li>
 * <li>每列的元素从上到下升序排列。</li>
 *
 */
public class P240 {
    //不是哥们，给的这个矩阵特点到底怎么用啊
    //可以沿对角线搜索吗？不对，不是正方形，未必有对角线
    //先对每一行二分查找看看能不能过吧
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
