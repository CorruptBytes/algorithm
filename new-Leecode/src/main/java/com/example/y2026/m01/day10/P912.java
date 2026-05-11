package com.example.y2026.m01.day10;

/**
 * <h1>排序数组</h1>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 */
public class P912 {
    //快速排序解决
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = nums[left],i = left - 1,j = right + 1;
        while (i < j) {
            do {i++;} while (nums[i] < pivot);
            do {j--;} while (nums[j] > pivot);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums,j + 1,right);
        quickSort(nums,left,j);
    }

    /**
     第二个快排实现，挖坑填坑法，非常依赖pivot的选择，如果选择的不好可能性能会很差,可以用随机数优化
     int pivotIndex = l + (int)(Math.random() * (r - l + 1));
     int pivot = nums[pivotIndex];
     nums[pivotIndex] = nums[l]; // 把 pivot 换到最左
     */
    public void quickSortV2(int[] nums,int l,int r) {
        if (l >= r) return;
        int pivot = nums[l];
        int low = l,high = r;
        while (low != high) {
            while (low != high && nums[high] >= pivot) {
                high--;
            }
            nums[low]= nums[high];
            while (low != high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = pivot;
        quickSortV2(nums,l,high - 1);
        quickSortV2(nums,high + 1,r);
    }
}
