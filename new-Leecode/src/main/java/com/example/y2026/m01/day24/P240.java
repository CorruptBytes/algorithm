package com.example.y2026.m01.day24;
/**
 * <h1>搜索二维矩阵Ⅱ</h1>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <li>每行的元素从左到右升序排列。</li>
 * <li>每列的元素从上到下升序排列。</li>
 *
 */
public class P240 {
    //对每一行进行二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (nums[0] > target) return false;
            boolean success = binarySearch(nums, target);
            if (success) return true;
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
