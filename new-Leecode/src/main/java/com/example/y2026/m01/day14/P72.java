package com.example.y2026.m01.day14;
/**
 * <h1>编辑距离</h1>
 * <p>给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符</p>
 * <a href="https://leetcode.cn/problems/edit-distance">链接</a>
 */
public class P72 {
    //动态规划
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 * n2 == 0) return n1 + n2;
        //dp[i][j] 代表 word1 中前 i 个字符，变换到 word2 中前 j 个字符，最短需要操作的次数
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //分别表示三种操作，对word1插入一个字符，对word2插入一个字符和对word1或word2替换一个字符。
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
