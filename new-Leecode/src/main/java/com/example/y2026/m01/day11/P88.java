package com.example.y2026.m01.day11;

/**
 * <h1>合并两个有序数组</h1>
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class P88 {
//    先使用非原地合并试试
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i1 = 0,i2 = 0;
        int index = 0;
        while (index < m + n) {
            int cur = 0;
            if (i1 < m && i2 < n) {
                if (nums1[i1] < nums2[i2]) {
                    cur = nums1[i1];
                    i1++;
                } else {
                    cur = nums2[i2];
                    i2++;
                }
                result[index++] = cur;
                continue;
            }
            cur = i1 < m ? nums1[i1++] : nums2[i2++];
            result[index++] = cur;
        }
        System.arraycopy(result,0,nums1,0,m + n);
    }

    //逆向双指针
    public void mergeV1(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int index = m + n - 1;
        int cur;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 == -1) {
                cur = nums2[index2--];
            } else if (index2 == -1) {
                cur = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                cur = nums1[index1--];
            } else {
                cur = nums2[index2--];
            }
            nums1[index--] = cur;
        }
    }
}
