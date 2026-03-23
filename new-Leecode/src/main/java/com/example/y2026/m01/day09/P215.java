package com.example.y2026.m01.day09;

/**
 * <h1>数组中的第K个最大元素</h1>
 */
public class P215 {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,nums.length - k,0,nums.length - 1);
    }

    public int quickSelect(int[] nums, int k,int left, int right) {
        if (left == right) return nums[k];
        int pivot = nums[left], i = left - 1, j = right + 1;
        while (i < j) {
            do {i++;} while (nums[i] < pivot);
            do {j--;} while (nums[j] > pivot);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (k <= j) {
            return quickSelect(nums,k, left,j);
        } else {
            return quickSelect(nums,k,j + 1, right);
        }
    }
}
