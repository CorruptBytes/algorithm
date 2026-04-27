package com.example.y2026.m01.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>全排列</h1>
 * <p>给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。</p>
 * <a href="https://leetcode.cn/problems/permutations">链接</a>
 */
public class P46 {
    //回溯算法
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums,list,res,used);
        return res;
    }
    public void backtracking(int[] nums,List<Integer> list,List<List<Integer>> res,boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums,list,res,used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
