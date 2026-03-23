package com.example.day42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>全排列Ⅱ</h1>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class P47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        backtracking(nums,result,results,flag);
        return results;
    }
    public void backtracking(int[] nums,List<Integer> result,List<List<Integer>> results,boolean[] flag) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) || flag[i]) {
                continue;
            }
            result.add(nums[i]);
            flag[i] = true;
            backtracking(nums,result,results,flag);
            result.removeLast();
            flag[i] = false;
        }
    }

    //方法二，本质与1无区别
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] used;
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        used = new boolean[nums.length];
//        backTracking(nums);
//        return res;
//    }

    private void backTracking(int[] nums){

        if(nums.length == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }

        boolean[] layerUsed = new boolean[21];

        for(int i=0;i<nums.length;i++){
            if(used[i] || layerUsed[nums[i]+10]) continue;

            layerUsed[nums[i]+10] = true;
            used[i] = true;
            list.add(nums[i]);
            backTracking(nums);
            used[i] = false;
            list.removeLast();
        }
    }

}
