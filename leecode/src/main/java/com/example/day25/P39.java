package com.example.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>组合求和</h1>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class P39 {
    //回溯算法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        backtracking(candidates,target,results,result,0,0);
        return results;
    }
    public void backtracking(int[] candidates,int target, List<List<Integer>> results, List<Integer> result,int sum,int startIndex) {
        if (sum == target) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            result.add(candidates[i]);
            backtracking(candidates,target,results,result,sum + candidates[i],i);
            result.remove(result.size() - 1);
        }
    }
}
