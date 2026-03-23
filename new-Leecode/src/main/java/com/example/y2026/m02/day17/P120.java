package com.example.y2026.m02.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>三角形最小路径和</h1>
 * <p>给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。</p>
 * <a href="https://leetcode.cn/problems/triangle">链接</a>
 */
public class P120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.getFirst());
        for (int i = 1; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                List<Integer> list = dp.get(i - 1);
                List<Integer> list1 = triangle.get(i);
                if (j == 0) {
                    temp.add(list.get(j) + list1.get(j));
                }else if (j == i) {
                    temp.add(list.get(j - 1) + list1.get(j));
                }
                else {
                    temp.add(Math.min(list.get(j),list.get(j - 1)) + list1.get(j));
                }
            }
            dp.add(temp);
        }
        List<Integer> list = dp.get(n - 1);
        int max = list.stream().min(Integer::compareTo).get();
        return max;
    }
}
