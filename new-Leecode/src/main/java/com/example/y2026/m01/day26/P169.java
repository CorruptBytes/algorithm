package com.example.y2026.m01.day26;
/**
 * <h1>多数元素</h1>
 * <p>给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素</p>
 * <a href="https://leetcode.cn/problems/majority-element">链接</a>
 */
public class P169 {

    public int majorityElement(int[] nums) {
        int cur = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) cur = num;
            count += cur == num ? 1 : -1;
        }
        return cur;
    }
}
