package com.example.day26;


import java.util.HashMap;
import java.util.Map;

/**
 * <h1>和为K的子数组</h1>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <h2>进阶</h2>
 * 可不可以返回符合条件子数组的索引范围。
 */
public class P560 {
    //前缀和加哈希表,需要遍历两次
//    public int subarraySum(int[] nums, int k) {
//        int n = nums.length;
//        int[] s = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            s[i + 1] = s[i] + nums[i];
//        }
//        Map<Integer,Integer> map = new HashMap<>(n + 1,1);
//        int result = 0;
//        for (int sum : s) {
//            result +=  map.getOrDefault(sum - k,0);
//            map.merge(sum,1,Integer::sum);
//        }
//        return result;
//    }
    //改进，只需要遍历一次
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(nums.length + 1,1);
        int s = 0;
        int result = 0;
        for (int num : nums) {
            map.merge(s,1,Integer::sum);
            s += num;
            result += map.getOrDefault(s - k,0);
        }
        return result;
    }


}
