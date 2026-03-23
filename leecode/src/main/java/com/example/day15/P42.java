package com.example.day15;

/**
 * <h1>接雨水</h1>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class P42 {
    //动态规划
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i],rightMax[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.max(leftMax[i],rightMax[i]) - height[i];
        }
        return sum;
    }
}
