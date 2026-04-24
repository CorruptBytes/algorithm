package com.example.y2026.m01.day22;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>和为K的子数组</h1>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k">链接</a>
 * <h2>进阶</h2>
 * 可不可以返回符合条件子数组的索引范围。
 */
public class P560 {
    //前缀和
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(nums.length + 1,1);
        int result = 0;
        int sum = 0;
        map.put(0,1);
        for (int num : nums) {
            map.merge(sum,1,Integer::sum);
            sum += num;
            result += map.getOrDefault(sum - k,0);
        }
        return result;
    }

    //前缀和解法
    public int subarraySumV1(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(sum,1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k,0);
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return res;
    }

}
