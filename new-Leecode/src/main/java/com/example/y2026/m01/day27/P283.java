package com.example.y2026.m01.day27;

import java.util.Arrays;

/**
 * <h1>移动零</h1>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class P283 {
    /**
     * 双指针，一个指针遍历数组，一个指针记录非0元素应该放置的位置
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int curIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[curIndex++] = nums[i];
            }
        }
        Arrays.fill(nums,curIndex,n,0);
    }

    public void moveZeroesV1(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }




}
