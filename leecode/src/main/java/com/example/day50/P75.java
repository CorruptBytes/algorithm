package com.example.day50;

import java.util.Arrays;

/**
 * <h1>颜色分类</h1>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class P75 {

    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        int n = nums.length;
        for (int num : nums) {
            colors[num]++;
        }
        int i1 = colors[0];
        int i2 = colors[0] + colors[1];
        Arrays.fill(nums,0,i1,0);
        Arrays.fill(nums,i1,i2,1);
        Arrays.fill(nums,i2,n,2);
    }
}
