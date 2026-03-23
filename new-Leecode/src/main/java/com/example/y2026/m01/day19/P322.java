package com.example.y2026.m01.day19;

import java.util.Arrays;

/**
 * <h1>零钱兑换</h1>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class P322 {
    //看题解说是动态规划
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i - coin] != 0) {
                        if (dp[i] != 0) {
                            dp[i] = Math.min(dp[i - coin] + 1,dp[i]);
                        } else dp[i] = dp[i - coin] + 1;
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
    //同样是动态规划逻辑更加紧密，判断条件少
    public int coinChangeV1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
