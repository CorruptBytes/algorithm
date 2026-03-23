package com.example.y2026.m01.day14;

/**
 * <h1>最长公共子序列</h1>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 */
public class P1143 {
    //感觉可以动态规划
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        if (n1 * n2 == 0) return 0;
        //dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度。
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //当 text1[i - 1] == text2[j - 1] 时，说明两个子字符串的最后一位相等，
                    // 所以最长公共子序列又增加了 1，所以 dp[i][j] = dp[i - 1][j - 1] + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //当 text1[i - 1] != text2[j - 1]时，说明两个子字符串的最后一位不相等，
                    // 那么此时的状态 dp[i][j] 应该是 dp[i - 1][j] 和 dp[i][j - 1] 的最大值
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
