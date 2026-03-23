package com.example.y2026.m01.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>组合总和Ⅱ</h1>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */
public class P40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>(candidates.length);
        int[] used = new int[candidates.length];
        backtracking(candidates,target,res,nums,0,0,used);
        return res;
    }

    public void backtracking(int[] candidates,int target, List<List<Integer>> res, List<Integer> nums,int sum,int start,int[] used) {
        if (sum == target) {
            res.add(new ArrayList<>(nums));
            return;
        }
        if (sum > target) return;
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && used[i - 1] == 0 && candidates[i] == candidates[i - 1]) continue;
            nums.add(candidates[i]);
            used[i] = 1;
            backtracking(candidates,target,res,nums,sum + candidates[i],i + 1,used);
            used[i] = 0;
            nums.removeLast();
        }
    }
}
