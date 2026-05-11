package com.example.y2026.m02.day4;

import java.util.Arrays;

/**
 * <h1>颜色分类</h1>
 * <p>给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。</p>
 * <a href="https://leetcode.cn/problems/sort-colors">链接</a>
 */
public class P75 {

    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int num : nums) {
            switch (num) {
                case 0 -> red++;
                case 1 -> white++;
                case 2 -> blue++;
            }
        }
        Arrays.fill(nums,0,red,0);
        Arrays.fill(nums,red,red + white,1);
        Arrays.fill(nums,red + white,red + white + blue,2);
    }
    //一次扫描
    public void sortColorsV1(int[] nums) {
        int n = nums.length;
        //下一个0应该被交换到的位置
        int p0 = 0;
        //下一个1应该被交换到的位置
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                //如果i扫描到1，直接交换即可，同时将p1指向下一个位置
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            } else if (nums[i] == 0) {
                //如果i扫描到0，先将i与p0交换；由于0后面是一连串的1,如果p0 < p1，说明此时会将一个1交换到了i位置
                //需要再将它交换回来
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                //由于0在1前面，因此p0 和 p1 均需要更新
                p0++;
                p1++;
            }
        }
    }
}
