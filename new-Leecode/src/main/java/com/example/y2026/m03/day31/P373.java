package com.example.y2026.m03.day31;

import java.util.ArrayList;
import java.util.List;

/*
    <h1>查找和最小的K对数字</h1>
    <p>
    给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
    定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
    请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
    </p>
 */

public class P373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int i1 = 0;
        int i2 = 0;
        int len1 = nums1.length - 1;
        int len2 = nums2.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(nums1[i1],nums2[i2]));
        while (i1 == len1 || i2 == len2) {
            if (i1 == len1) {
                i2++;
                res.add(List.of(nums1[i1],nums2[i2]));
            } else if (i2 == len2) {
                i1++;
                res.add(List.of(nums1[i1],nums2[i2]));
            } else {
                if (nums1[i1 + 1] + nums2[i2] > nums1[i1] + nums2[i2 + 1]) {
                    i2++;
                    res.add(List.of(nums1[i1], nums2[i2]));
                } else {
                    i1++;
                    res.add(List.of(nums1[i1],nums2[i2]));
                }
            }
            
        }
        return res;
    }
}
