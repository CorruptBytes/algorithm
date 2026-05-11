package com.example.y2026.m01.day25;
/**
 * <h1>乘积最大子数组</h1>
 * <p>给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * * 测试用例的答案是一个 32-位 整数。</p>
 * <a href="https://leetcode.cn/problems/maximum-product-subarray">链接</a>
 */
public class P152 {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            //先保存 max
            int tmpMax = max;
            max = Math.max(cur, Math.max(max * cur, min * cur));
            min = Math.min(cur, Math.min(tmpMax * cur, min * cur));
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public int maxProductV1(int[] nums) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        int pre = 0, suf = 0;

        // 从左往右（前缀）
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            pre *= nums[i];
            mx = Math.max(mx, pre);
        }

        // 从右往左（后缀）
        for (int i = n - 1; i >= 0; i--) {
            if (suf == 0) suf = 1;
            suf *= nums[i];
            mx = Math.max(mx, suf);
        }

        return mx;
    }
}
