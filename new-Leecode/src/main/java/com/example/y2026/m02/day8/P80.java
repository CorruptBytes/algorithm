package com.example.y2026.m02.day8;

/**
 * <h1>删除有序数组中的重复项Ⅱ</h1>
 * <p>给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。</p>
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description">链接</a>
 */
public class P80 {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        int i = 0;
        int n = nums.length;
        while (i < n - 1) {
            if (nums[i] == nums[i + 1]) {
                int num = nums[i];
                nums[len++] = nums[i++];
                nums[len++] = nums[i++];
                while (i < n && nums[i] == num) {
                    i++;
                }

            } else {
                nums[len++] = nums[i++];
            }
        }
        if (i < n) {
            nums[len++] = nums[i];
        }
        return len;
    }
}
