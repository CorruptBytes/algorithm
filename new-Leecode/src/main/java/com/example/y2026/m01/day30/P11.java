package com.example.y2026.m01.day30;
/**
 * <h1>盛水最多的容器</h1>
 */
public class P11 {
    //贪心,容器的容量是受较小边界影响，因此每次移动较小的边界，以期待容量变大。
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                max = Math.max(height[l] * (r - l),max);
                l++;
            } else {
                max = Math.max(height[r] * (r - l),max);
                r--;
            }
        }
        return max;
    }
}
