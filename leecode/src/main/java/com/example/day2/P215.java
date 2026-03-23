package com.example.day2;

import java.util.Arrays;

/**
 * <h1>数组中的第K个最大元素</h1>
 */
public class P215 {

    /**
     *
     * @param nums
     * @param k
     * @return  给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *     请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *     你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    //最简单的方法，直接使用编程语言自带的排序API排序后返回指定位置的元素
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }
    public int quickselect(int[] nums, int l, int r, int k) {
            if (l == r) return nums[k];
            int x = nums[l], i = l - 1, j = r + 1;
            //排序后，j将数组分成了两个局部有序的区间,[l,j]中的所有元素<=x,[j + 1,r]中的所有元素>=x
            while (i < j) {
                do i++; while (nums[i] < x);
                do j--; while (nums[j] > x);
                if (i < j){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            if (k <= j) return quickselect(nums, l, j, k);
            else return quickselect(nums, j + 1, r, k);
        }





}
