package com.example.y2026.m02.day4;

import java.util.Arrays;

/**
 * <h1>颜色分类</h1>
 * <p>给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。</p>
 * <a href="">链接</a>
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
}
