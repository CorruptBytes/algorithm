package com.example.y2026.m01.day26;
/**
 * <h1>长度最小的子数组</h1>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class P209 {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0,r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(min,r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
