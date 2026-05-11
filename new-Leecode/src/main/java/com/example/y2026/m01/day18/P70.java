package com.example.y2026.m01.day18;


/**
 * <h1>爬楼梯</h1>
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *  * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>
 *  <a href="https://leetcode.cn/problems/climbing-stairs">链接</a>
 */
public class P70 {
    //动态规划
    public int climbStairs(int n) {
        int[] dp = {1,2,3};
        if (n <= 3) {
            return dp[n - 1];
        }
        for (int i = 0; i < n - 3; i++) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[0] + dp[1];
        }
        return dp[2];
    }
}
