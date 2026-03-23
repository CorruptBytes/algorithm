package com.example.y2026.m02.day3;
/**
 * <h1>除自身以外数组的乘积</h1>
 * <p> 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *  题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *  请 不要使用除法，且在 O(n) 时间复杂度内完成此题。</p>
 *  <a href="https://leetcode.cn/problems/product-of-array-except-self/description/">链接</a>
 */
public class P238 {

    //空间复杂度O(n)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        R[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = nums[i - 1] * L[i - 1];
            R[n - i - 1] = nums[n - i] * R[n - i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }

    //空间复杂度O(1)
    public int[] productExceptSelfV1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = r * result[i];
            r *= nums[i];
        }
        return result;
    }
}
