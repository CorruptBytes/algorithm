package com.example.y2026.m01.day24;
/**
 * <h1>寻找峰值</h1>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class P162 {
    //O(log n)的话需要二分法，这该怎么二分

    /**
     * 如果 i<n−1 且 nums[i]<nums[i+1]，那么在下标 [i+1,n−1] 中一定存在峰值。
     * 证明：反证法，假设下标 [i+1,n−1] 中没有峰值。
     * 由于 i+1 不是峰值且 nums[i]<nums[i+1]，所以一定有 nums[i+1]<nums[i+2] 成立，否则 i+1 就是峰值了。
     * 注意题目保证相邻元素不同，不存在相邻元素相等的情况。
     * 由于 i+2 不是峰值且 nums[i+1]<nums[i+2]，所以一定有 nums[i+2]<nums[i+3] 成立，否则 i+2 就是峰值了。
     * 依此类推，得
     * nums[i]<nums[i+1]<nums[i+2]<⋯<nums[n−1]>nums[n]=−∞
     * 这意味着 nums[n−1] 是峰值，矛盾，所以原命题成立。
     * 同理可得，如果 i<n−1 且 nums[i]>nums[i+1]，那么在 [0,i] 中一定存在峰值。
     * 所以，通过比较 nums[i] 和 nums[i+1] 的大小关系，不断地缩小存在峰值的范围，二分找到峰值。
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
