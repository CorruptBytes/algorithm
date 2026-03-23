package com.example.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class P46 {

    //回溯算法暴力求解
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] used = new int[nums.length];
        backtracking(result,list,used,nums);
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> list,int[] used,int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            list.add(nums[i]);
            used[i] = 1;
            backtracking(result,list,used,nums);
            list.removeLast();
            used[i] = 0;
        }
    }
}
