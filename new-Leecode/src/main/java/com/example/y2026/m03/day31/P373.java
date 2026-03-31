package com.example.y2026.m03.day31;

import java.util.ArrayList;
import java.util.List;

/**
 *     <h1>查找和最小的K对数字</h1>
 *     <p>
 *     给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *     定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *     请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *     </p>
 *     <a href="https://leetcode.cn/problems/find-k-pairs-with-smallest-sums">链接</a>
 */

public class P373 {
    //目前想法是列举出所有加和可能，使用小根堆依次弹出k个堆顶元素。
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    }

    public void createHeap(int[] arr) {
        int len = arr.length;
        int lastNumber = len / 2;
        while (lastNumber > 0) {
            int index = lastNumber - 1;
            swap(arr, index,len);
            lastNumber--;
        }
    }

    public void swap(int[] arr,int rootIndex,int len) {
        boolean left = false;
        boolean right = false;
        if (rootIndex * 2 + 2 < len) {
            if (arr[rootIndex] < arr[rootIndex * 2 + 1] || arr[rootIndex] < arr[rootIndex * 2 + 2]) {
                if (arr[rootIndex * 2 + 1] < arr[rootIndex * 2 + 2]) {
                    int temp = arr[rootIndex];
                    arr[rootIndex] = arr[rootIndex * 2 + 2];
                    arr[rootIndex * 2 + 2] = temp;
                    right = true;
                } else {
                    int temp = arr[rootIndex];
                    arr[rootIndex] = arr[rootIndex * 2 + 1];
                    arr[rootIndex * 2 + 1] = temp;
                    left = true;
                }
            }
        } else {
            if (rootIndex * 2 + 1 < len) {
                if (arr[rootIndex] < arr[rootIndex * 2 + 1]) {
                    int temp = arr[rootIndex];
                    arr[rootIndex] = arr[rootIndex * 2 + 1];
                    arr[rootIndex * 2 + 1] = temp;
                    left = true;
                }
            }
        }
        if (left) {
            swap(arr, rootIndex * 2 + 1,len);
        } else if (right) {
            swap(arr, rootIndex * 2 + 2,len);
        }
    }
}
