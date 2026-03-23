package com.example.y2026.m01.day14;


/**
 * <h1>寻找两个正序数组的中位数</h1>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class P4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = (n1 + n2 + 1) / 2;
        int right = (n1 + n2 + 2) / 2;
        return (getKth(nums1,0,n1 - 1,nums2,0,n2 - 1,left) + getKth(nums1,0,n1 - 1,nums2,0,n2 - 1,right)) * 0.5;
    }
    public int getKth(int[] nums1,int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2,start2,end2,nums1,start1,end1,k);
        if (len1 == 0) return nums2[start2 + k  -1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1,k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1,start1,end1,nums2,j + 1,end2,k - (j - start2 + 1));
        } else {
            return getKth(nums1,i + 1,end1,nums2,start2,end2,k - (i - start1 + 1));
        }

    }

    //不考虑时间复杂度与空间复杂度,直接将数组重新排序组合为一个大数组，计算大数组的中位数
    // 时间复杂度为O(m + n),空间复杂度为O(m + n)
    public double findMedianSortedArraysV1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = n1 + n2;
        if (n1 == 0) {
            return n2 % 2 == 0 ? (nums2[n2 / 2] + nums2[n2 / 2 - 1]) / 2.0 : nums2[n2 / 2];
        }
        if (n2 == 0) {
            return n1 % 2 == 0 ? (nums1[n1 / 2] + nums1[n1 / 2 - 1]) / 2.0 : nums1[n1 / 2];
        }
        int[] arr = new int[n1 + n2];
        int i1 = 0,i2 = 0;
        int index = 0;
        while (index < n1 + n2) {
            while (i1 <n1 && index < n1 + n2 && nums1[i1] <= nums2[i2]) {
                arr[index++] = nums1[i1++];
            }
            if (i1 == n1) {
                while (index < n1 + n2 && i2 < n2) {
                    arr[index++] = nums2[i2++];
                }
                break;
            }
            while (i2 < n2 && index < n1 + n2 && nums2[i2] <= nums1[i1]) {
                arr[index++] = nums2[i2++];
            }
            if (i2 == n2) {
                while (index < n1 + n2 && i1 < n1) {
                    arr[index++] = nums1[i1++];
                }
                break;
            }
        }
        return n3 % 2 == 0 ? (arr[n3 / 2] + arr[n3 / 2 - 1]) / 2.0 : arr[n3 / 2];
    }
}
