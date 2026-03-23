package com.example.y2026.m01.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>子集</h1>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class P78 {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>(n);
        List<List<Integer>> results = new ArrayList<>((int) Math.pow(2,n));
        backtracking(results,result,nums,0);
        return results;
    }

    public void backtracking(List<List<Integer>> results, List<Integer> result, int[] nums,int start) {
        results.add(new ArrayList<>(result));
        if (start == nums.length) return;
        for (int i = start; i < nums.length; i++) {
            result.add(nums[i]);
            backtracking(results,result,nums,i + 1);
            result.removeLast();
        }
    }
}
