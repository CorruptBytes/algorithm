package com.example.y2026.m02.day6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>柱状图中最大的矩形</h1>
 * <p>给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
 * 每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>
 * <a href="">链接</a>
 */
public class P84 {

    //先尝试暴力解法,时间复杂度O(n**2)

    //枚举宽度
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int min = heights[0];
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            min = heights[i];
            max = Math.max(min,max);
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min,heights[j]);
                max = Math.max(min * (j - i + 1), max);
            }
        }
        return max;
    }
    //枚举高度
    public int largestRectangleAreaV1(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int mid = 0; mid < n; ++mid) {
            // 枚举高
            int height = heights[mid];
            int left = mid, right = mid;
            // 确定左右边界
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < n && heights[right + 1] >= height) {
                ++right;
            }
            // 计算面积
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }
    //如何降低O(n**2)的复杂度
    public int largestRectangleAreaV2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //通过栈，维护一个从小到大的结构
        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        //从左向右遍历，只保存高度小于当前高度的索引值，确定每一个高度的左边界
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
            mono_stack.push(i);
        }

        mono_stack.clear();
        //从右向左遍历，只保存高度小于当前高度的索引值，确定每一个高度的右边界
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = mono_stack.isEmpty() ? n : mono_stack.peek();
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
