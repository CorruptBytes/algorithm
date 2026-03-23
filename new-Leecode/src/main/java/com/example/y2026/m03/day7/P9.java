package com.example.y2026.m03.day7;

/**
 * <h1>交错字符串</h1>
 * <p>给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。</p>
 * <a href="https://leetcode.cn/problems/interleaving-string">链接</a>
 */
public class P9 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        if (n == 0 && m == 0) return true;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j != 0) {
                    dp[i][j] = s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j] ||
                               s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1];
                } else {
                    dp[i][j] = s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
