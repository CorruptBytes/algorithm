package com.example.y2026.m01.day30;
/**
 * <h1>盛水最多的容器</h1>
 */
public class P11 {
    //贪心思想,从容器的两个端点开始枚举，由于容器的容量是受较小边界影响，因此每次向内移动较小的边界，以期待容量变大。
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
          max = Math.max(Math.min(height[l],height[r]) * (r - l),max);
          if (height[l] < height[r]) l++;
          else r--;
        }
        return max;
    }
}
