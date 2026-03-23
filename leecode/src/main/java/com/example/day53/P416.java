package com.example.day53;

/**
 * <h1>分隔等和子集</h1>
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 */
public class P416 {
    //dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），
    // 是否存在一种选取方案使得被选取的正整数的和等于 j
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            max = Math.max(num,max);
        }
        int target = sum / 2;
        if (sum % 2 != 0 || max > target) return false;
        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
