package com.example.y2026.m01.day25;
/**
 * <h1>乘积最大子数组</h1>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * * 测试用例的答案是一个 32-位 整数。
 */
public class P152 {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(max * nums[i],Math.max(nums[i],min * nums[i]));
            min = Math.min(temp * nums[i],Math.min(nums[i],min * nums[i]));
            res = Math.max(max,res);
        }
        return res;
    }
}
