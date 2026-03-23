package com.example.y2026.m03.day11;

/**
 * <h1>只出现一次的数字Ⅱ</h1>
 * <p>给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。</p>
 * <a href="https://leetcode.cn/problems/single-number-ii">链接</a>
 */
public class P137 {

    public int singleNumber(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                count += (nums[j] >> i & 1);
            }
            res += ((count % 3) << i);
        }

        return res;
    }
}
