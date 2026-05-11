package com.example.y2026.m01.day29;
/**
 * <h1>寻找旋转排序数组中的最小值</h1>
 * <p>已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。</p>
 * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array">链接</a>
 */
public class P153 {
    //二分查找
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        //以最右侧元素作为基准值，它将数组分成两个部分，一部分全部大于pivot，另一部分全部小于pivot
        int pivot = nums[r];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < pivot) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
    //两种写法均是在找第一个满足nums[i] < pivot的位置，但是第二种写法在数组没有旋转时，不存在nums[i] < pivot，因此需要特判。
    public int findMinV1(int[] nums) {
        int l = 0, r = nums.length - 1;
        int pivot = nums[0];
        if (pivot <= nums[r]) return pivot;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < pivot) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
