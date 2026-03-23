package com.example.y2026.m02.day3;
/**
 * <h1>轮转数组</h1>
 * <p>给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。</p>
 * <a href="https://leetcode.cn/problems/rotate-array/">链接</a>
 */
public class P189 {
    //空间复杂度O(n)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp,0,nums,0,n);
    }
    //空间复杂度O(1)
    public void rotateV1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
    public void reverse(int[] nums,int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
