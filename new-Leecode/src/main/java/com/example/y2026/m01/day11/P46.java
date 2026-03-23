package com.example.y2026.m01.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>全排列</h1>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class P46 {
    //回溯算法
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>(n);
        List<List<Integer>> results = new ArrayList<>();
        int[] used = new int[6];
        backtracking(nums,results,result,used);
        return results;
    }
    public void backtracking(int[] nums, List<List<Integer>> results, List<Integer> result,int[] used) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            result.add(nums[i]);
            used[i] = 1;
            backtracking(nums,results,result,used);
            result.removeLast();
            used[i] = 0;
        }
    }
}
