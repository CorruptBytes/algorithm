package com.example.day44;

/**
 * <h1>跳跃游戏</h1>
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class P55 {
    //动态规划,dp数组表示当前位置是否可达
    public boolean canJumpV1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                for (int j = i; j < Math.min(nums.length, i + nums[i] + 1); j++) {
                    dp[j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
    /*只需要遍历时更新可达的最远位置，当可达的最远位置超过数组索引时，表名终点可达，否则不可达*/
    public boolean canJumpV2(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover,i + nums[i]);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}
