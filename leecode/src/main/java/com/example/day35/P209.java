package com.example.day35;

/**
 * <h1>长度最小的子数组</h1>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class P209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min,right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
