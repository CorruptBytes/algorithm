package com.example.day31;

/**
 * <h1>寻找峰值</h1>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class P162 {
    //要求O(log n)?又不是有序数组，没法用二分查找，真能不遍历吗?
    //先不考虑时间复杂度
//    public int findPeakElement(int[] nums) {
//        int result = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (i == 0) {
//                if (i + 1 == nums.length) {
//                    return 0;
//                } else {
//                    if (nums[i + 1] < nums[i]) {
//                        return 0;
//                    }
//                }
//                continue;
//            }
//            if (i < nums.length - 1) {
//                if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
//                    return i;
//                }
//            }
//        }
//        return nums.length - 1;
//    }
    //二分法，由于题目保证nums[-1] = nums[n] = -∞，则二分法比较nums[i]与nums[i + 1],大的方向一定存在峰值
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
    /**
     * 定理：如果 i<n−1 且 nums[i]<nums[i+1]，那么在下标 [i+1,n−1] 中一定存在峰值。
     * 证明：反证法，假设下标 [i+1,n−1] 中没有峰值。
     * 由于 i+1 不是峰值且 nums[i]<nums[i+1]，所以一定有 nums[i+1]<nums[i+2] 成立，否则 i+1 就是峰值了。注意题目保证相邻元素不同，不存在相邻元素相等的情况。
     * 由于 i+2 不是峰值且 nums[i+1]<nums[i+2]，所以一定有 nums[i+2]<nums[i+3] 成立，否则 i+2 就是峰值了。
     * 依此类推，得
     * nums[i]<nums[i+1]<nums[i+2]<⋯<nums[n−1]>nums[n]=−∞
     * 这意味着 nums[n−1] 是峰值，矛盾，所以原命题成立。
     * 同理可得，如果 i<n−1 且 nums[i]>nums[i+1]，那么在 [0,i] 中一定存在峰值。
     * 所以，通过比较 nums[i] 和 nums[i+1] 的大小关系，不断地缩小存在峰值的范围，二分找到峰值。。
     */
}
