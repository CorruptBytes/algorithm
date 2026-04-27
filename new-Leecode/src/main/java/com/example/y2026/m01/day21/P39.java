package com.example.y2026.m01.day21;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>组合求和</h1>
 * <p>给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。</p>
 *
 * <a href="https://leetcode.cn/problems/combination-sum">链接</a>
 */
public class P39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        backtracking(results,result,candidates,target,0);
        return results;
    }

    private void backtracking(List<List<Integer>> results, List<Integer> result,int[] candidates,int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            result.add(candidates[i]);
            backtracking(results,result,candidates,target - candidates[i],i);
            result.remove(result.size() - 1);
        }
    }

}
