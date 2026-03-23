package com.example.y2026.m02.day5;

import java.util.Arrays;

/**
 * <h1>分隔等和子集</h1>
 * <p>给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等</p>
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">链接</a>
 */
public class P416 {
    //回溯，怎么剪枝都是超时.
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return backtracking(nums,target,0);
    }

    public boolean backtracking(int[] nums, int target, int start) {
        if (target == 0) return true;
        if (target < 0) return false;
        boolean flag = false;
        for (int i = start; i < nums.length; i++) {
            flag = backtracking(nums,target - nums[i],i + 1);
            if (flag) return true;
        }
        return false;
    }

    boolean flag = false;
    public boolean canPartitionV1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        backtrackingV1(nums,target,0);
        return flag;
    }

    public void backtrackingV1(int[] nums, int target, int start) {
        if (target == 0) {
            flag = true;
            return;
        }
        if (target < 0) return;
        for (int i = start; i < nums.length; i++) {
            backtrackingV1(nums,target - nums[i],i + 1);
            if (flag) return;
        }
    }

    //给动态规划跪了
    //dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），
    // 是否存在一种选取方案使得被选取的正整数的和等于 j
    public boolean canPartitionV2(int[] nums) {
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
