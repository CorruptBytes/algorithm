package com.example.y2026.m01.day26;
/**
 * <h1>多数元素</h1>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 */
public class P169 {

    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) cur = nums[i];
            count += nums[i] == cur ? 1 : -1;
        }
        return cur;
    }
}
