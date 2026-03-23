package com.example.y2026.m02.day12;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>汇总区间</h1>
 * <p>给定一个  无重复元素 的 有序 整数数组 nums 。
 * 区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b</p>
 * <a href="https://leetcode.cn/problems/summary-ranges">链接</a>
 */
public class P228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            if (i - start == 1) {
                res.add(nums[start] + "");
            } else {
                res.add(nums[start] + "->" + nums[i - 1]);
            }
        }
        return res;
    }
}
