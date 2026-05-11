package com.example.y2026.m01.day20;
/**
 * <h1>在排序数组中查找元素的第一个和最后一个位置</h1>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */


public class P34 {
    //二分查找
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target - 1) + 1;
        int right = binarySearch(nums,target);
        return left <= right ? new int[]{left,right} : new int[]{-1,-1};
    }

    /**
     * 思考二分查找的数学推导，为什么l与r会以这样的规律演变
     */

    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        /**
         * r 指向的：
         * 最后一个 ≤ target 的元素
         * l 指向的：
         * 第一个 > target 的元素
         */
        return r;
    }


}
