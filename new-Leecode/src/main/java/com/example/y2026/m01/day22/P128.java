package com.example.y2026.m01.day22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>最长连续序列</h1>
 *给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class P128 {
    //还是看题解
    public int longestConsecutive(int[] nums) {
        //将数存入HashSet中，因为HashSet查找效率高，且可以去重
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            //如果set中不存在比当前数小1的数，说明当前数为序列的起始，往后查找是否存在比他大的数，算出以此为起始的序列长度
            //最终大概需要遍历3次数组，即为O(n) = 3N
            if (!set.contains(num - 1)) {
                int len = 1;
                num++;
                while (set.contains(num)) {
                    len++;
                    num++;
                }
                max = Math.max(max,len);
            }
        }
        return max;
    }
}
