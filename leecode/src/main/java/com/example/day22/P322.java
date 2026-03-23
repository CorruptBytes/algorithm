package com.example.day22;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <h1>零钱兑换</h1>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class P322 {
    //动态规划,不是怎么效率这么低，才超过百分之18
    /*
    dp[i]代表凑齐i + 1元最少使用的硬币，如果为0则说明不可能凑齐。
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] validCoins = Arrays.stream(coins).filter(value -> value <= amount).toArray();
        int[] dp = new int[amount];
        for (int coin : validCoins) {
            dp[coin - 1] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int coin : validCoins) {
                if (i - coin >= 0 && dp[i - coin] > 0) {
                    dp[i] = dp[i] == 0 ? dp[i - coin] + 1 : Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return dp[amount -1] == 0 ? -1 : dp[amount - 1];
    }
}
