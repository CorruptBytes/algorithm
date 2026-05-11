package com.example.y2026.m01.day09;

/**
 * <h1>数组中的第K个最大元素</h1>
 */
public class P215 {
    //快速查找，源自快速排序
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
    /**
     * 一些思考
     * 经过官方题解中 while() {} 部分的交换，可以知道 j 的右边全是 >= 枢轴的数，
     * i 的左边全是 <= 枢轴的数。但是我们无法知道 nums[j] 是 < 枢轴还是 == 枢
     * 轴，也就是说 j 不一定能将其左边和右边都划分，只能划分出右边。所以当 k > j
     * 的时候，我们可以去 (j + 1, r) 这个区间去递归，但 k <= j 的时候，我们只
     * 能去 (l, j) 这个区间去划分，一直到l == r == k的时候才返回。
     *
     * 上面还有一个问题，那为什么不能用 i 来划分呢，比如写成：
     *         if(i > k)return quicSelect(nums, k, l, i - 1);
     *         else return quicSelect(nums, k, i, r);这样的形式。
     * ###  结论是可以，但是如果要用 i 来划分，枢轴得选最右边的数，也就是 nums[r]。
     *
     * 否则，又选择最左边的数当枢轴，又选用左指针来划分，试想一下如果右边的数全比这个
     * 枢轴大，eg: 1 2 [ 3 '5' 6 4 ]，关注这个[ ]中的部分，最后会出现 i = j = 2，
     * 而答案是5，又会往[ 3 '5' 6 4 ]这个区间递归，也就是**死循环**。问题的原因就在
     * 于我们选用的划分的指针 i 不移动！而不移动的原因又在于我们选用的枢轴在最左边，这
     * 会导致指针 i 在第一次内循环时留在枢轴，一直等到 j 跳出循环，那如果跳出循环时 i
     * 已经等于j了，就无法进入下一个外循环 i 也没办法移动了。
     *
     * 如果选最右边的值作为枢轴，也就是 int partition = nums[r]; 这样就会让 j 在
     * 第一次内循环留在枢轴，i 无论怎么样都能移动 --> 问题解决。
     */
}
