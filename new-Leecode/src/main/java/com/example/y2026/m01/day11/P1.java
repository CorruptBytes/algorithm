package com.example.y2026.m01.day11;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <h1>两数之和</h1>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 */
public class P1 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i,map.get(nums[i])};
            } else {
                map.put(target - nums[i],i);
            }
        }
        return null;
    }
}
