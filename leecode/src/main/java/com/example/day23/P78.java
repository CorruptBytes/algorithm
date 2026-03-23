package com.example.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>子集</h1>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class P78 {

    //回溯
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        List<List<Integer>> results = new ArrayList<>((int)Math.pow(2,nums.length));
        backtracking(nums,results,result,0);
        return results;
    }

    private void backtracking(int[] nums, List<List<Integer>> results, List<Integer> result, int startIndex) {
        results.add(new ArrayList<>(result));
        for (int i = startIndex; i < nums.length; i++) {
            result.add(nums[i]);
            backtracking(nums,results,result,i + 1);
            result.remove(result.size() - 1);
        }
    }

}
