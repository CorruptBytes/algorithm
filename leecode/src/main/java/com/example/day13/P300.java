package com.example.day13;


import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class P300 {
    //动态规划,dp数组元素中的每一个元素代表以i结尾的最长子序列,初始全部为1，因为子序列最短必定是元素本身
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            //遍历i之前的最长子序列，如果nums[i] > nums[j],则说明i可以加在j的最长子序列之后
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1,dp[i]);
            }
            result = Math.max(dp[i],result);
        }
       return  result;
    }
}
