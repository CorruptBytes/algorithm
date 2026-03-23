package com.example.day15;

/**
 * <h1>编辑距离</h1>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class P72 {

    public int minDistance(String word1, String word2) {
        int nums1 = word1.length();
        int nums2 = word2.length();
        int[][] dp = new int[nums1 + 1][nums2 + 1];
        for (int j = 0; j <= nums2; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= nums1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= nums1; i++) {
            for (int j = 1; j <= nums2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i - 1][j - 1];
                 else {
                     dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1,dp[i][j - 1] + 1),dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[nums1][nums2];
    }
}
