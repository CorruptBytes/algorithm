package com.example.y2026.m01.day13;


/**
 * <h1>接雨水</h1>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */

public class P42 {


    /**
     * 暴力解法
     * 某一位置雨水所能达到的最高水位为其左侧最高柱子与其右侧最高柱子两者的较小值(对于左右边缘位置，可视为其左侧(或右侧)柱子高度为0)，每一位置的最高水位一定大于等于当前柱子。
     * 下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]
     * 暴力解法是对于数组 height 中的每个元素，分别向左和向右扫描并记录左边和右边的最大高度，然后计算每个下标位置能接的雨水量。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        // 对每一个下标 i 计算能接的雨水
        for (int i = 0; i < n; i++) {

            // 1. 向左扫描，找左边最大高度
            int leftMax = 0;
            for (int l = 0; l <= i; l++) {
                leftMax = Math.max(leftMax, height[l]);
            }

            // 2. 向右扫描，找右边最大高度
            int rightMax = 0;
            for (int r = i; r < n; r++) {
                rightMax = Math.max(rightMax, height[r]);
            }

            // 3. 当前位置能接的雨水
            int water = Math.min(leftMax, rightMax) - height[i];

            // 4. 累加（小于 0 不加），不会存在小于0的情况。
            if (water > 0) {
                res += water;
            }
        }

        return res;
    }

    /**
     *空间换时间
     *
     * 每一位置的最高水位一定大于等于当前柱子
     * 先从左向右扫描，找到根据左侧最大高度，每一位置能达到的最高水位
     * 再从右向左扫描，找到根据右侧最大高度，每一位置能达到的最高水位
     * 两者的较小值减去柱子高度就是可接雨水的量
     *
     */
    public int trapV1(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i],left[i - 1]);
        }
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i],right[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(left[i],right[i]) - height[i];
        }
        return result;
    }
}
