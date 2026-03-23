package com.example.day42;

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
    //回溯
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int[] used = new int[candidates.length];
        backtracking(candidates,target,0,0,results,result,used);
        return results;
    }
    public void backtracking(int[] candidates,int target, int sum,int startIndex,List<List<Integer>> results,List<Integer> result,int[] used) {
        if (sum == target) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) continue;
            result.add(candidates[i]);
            used[i] = 1;
            backtracking(candidates,target,sum + candidates[i],i + 1,results,result,used);
            used[i] = 0;
            result.removeLast();
        }

    }
}
