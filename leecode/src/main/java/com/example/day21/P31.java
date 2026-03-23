package com.example.day21;

import java.util.Arrays;

/**
 * <h1>下一个排列</h1>
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 */
public class P31 {
    /*
    要保证排列变大的同时，变大的幅度最小。
    首先从右向左遍历找个第一个小于它右边元素的元素,因为要保证排列变大，就要将一个较小元素交换到一个较大元素的后边。
    同时保证变大幅度最小，因此这个较小元素要尽量靠右，且需要与它右边大于它的最小元素交换。
    此时较小元素(假设下标为i)右边(i + 1,n)的子序列是递减的。
    交换后(i + 1,n)仍然是递减了，当其递增时，字典序是最小的，所以将递减序列翻转即为最小的字典序。
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

