package com.example.y2026.m02.day3;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>将有序数组转换为二叉搜索树</h1>
 * <p>给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。</p>
 *  <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">链接</a>
 */
public class P108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums,0,nums.length - 1);
    }
    //选择中间位置左边的数字作为根节点
    public TreeNode createNode(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        root.left = createNode(nums,l,mid - 1);
        root.right = createNode(nums,mid + 1, r);
        return root;
    }
    //选择中间位置右边的数字作为根节点
    public TreeNode createNodeV1(int[] nums,int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createNode(nums,left,mid - 1);
        root.right = createNode(nums,mid + 1, right);
        return root;
    }
}
