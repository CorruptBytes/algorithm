package com.example.y2026.m01.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>全排列Ⅱ</h1>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class P47 {
    //回溯
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        int[] used = new int[nums.length];
        backtracking(res,path,nums,used);
        return res;
    }

    public void backtracking(List<List<Integer>> res,List<Integer> path,int[] nums,int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1] || used[i] == 1) continue;
            path.add(nums[i]);
            used[i] = 1;
            backtracking(res,path,nums,used);
            used[i] = 0;
            path.removeLast();
        }
    }
}
