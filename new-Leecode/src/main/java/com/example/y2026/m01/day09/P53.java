package com.example.y2026.m01.day09;

/**
 * <h1>最大子数组和</h1>
 * <p>给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。</p>
 * <a href="https://leetcode.cn/problems/maximum-subarray">链接</a>
 */
public class P53 {
    //贪心算法,如果前面的和小于0就舍弃,从当前数重新计算和
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }

}
