package com.example.y2026.m02.day5;

import java.util.Arrays;

/**
 * <h1>完全平方数</h1>
 * <p>给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。</p>
 * <a href="https://leetcode.cn/problems/perfect-squares/description/">链接</a>
 */
public class P279 {
    //动态规划
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int j = 1;
            while (i -(j * j) >= 0) {
                dp[i] = Math.min(dp[i],dp[i - (j * j)] + 1);
                j++;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public int numSquaresV1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min,dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
