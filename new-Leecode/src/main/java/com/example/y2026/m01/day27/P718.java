package com.example.y2026.m01.day27;
/**
 * <h1>最长重复子数组</h1>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class P718 {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //dp[i][j]表示nums1以i结尾的子数组和num2以j结尾的子数组的最长公共后缀。
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j -1] + 1 : 0;
                result = Math.max(dp[i][j],result);
            }
        }
        return result;
    }
}
