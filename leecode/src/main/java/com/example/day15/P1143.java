package com.example.day15;

import java.util.Arrays;

/**
 * <h1>最长公共子序列</h1>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 */
public class P1143 {
    //动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();

        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 0; i <= s1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= s2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[s1][s2];
    }
}
