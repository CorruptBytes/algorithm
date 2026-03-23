package com.example.day24;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.zip.GZIPInputStream;

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
        int low = binarySearch(nums,target);
        int high = binarySearch(nums,target + 1) - 1;
        return low <= high ? new int[]{low,high} : new int[]{-1,-1};
    }
    public int binarySearch(int[] nums,int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,3,3,5};
        P34 test = new P34();
        System.out.println(test.binarySearch(arr,4) + "   " + arr.length);
    }
}
