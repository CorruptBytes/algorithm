package com.example.y2026.m02.day12;

import java.util.*;

/**
 * <h1>存在重复元素Ⅱ</h1>
 * <p>给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。</p>
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii">链接</a>
 */
public class P219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            List<Integer> list = map.get(num);
            if (list != null) {
                for (Integer index : list) {
                    if (Math.abs(i - index) <= k) return true;
                }
                list.add(i);
            }
            list = new ArrayList<>();
            list.add(i);
            map.put(num, list);
        }
        return false;
    }
}
