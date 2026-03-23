package com.example.day19;

/**<h1>二分查找</h1>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 */
public class P704 {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;

            } else if (nums[mid]  < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
