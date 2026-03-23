package com.example.day48;

import com.leecode.structure.TreeNode;

/**
 * <h1>将有序数组转换为二叉搜索树</h1>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 */
public class P108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums,0,nums.length - 1);
    }
    //分治构造
    public TreeNode createNode(int[] nums,int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        //选择中间位置左边的数字作为根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createNode(nums,left,mid - 1);
        root.right = createNode(nums,mid + 1, right);
        return root;
    }

//    public TreeNode createNode(int[] nums,int left, int right) {
//        if (left > right) return null;
//        if (left == right) return new TreeNode(nums[left]);
//        //选择中间位置右边的数字作为根节点
//        int mid = left + (right - left + 1) / 2;
//        TreeNode root = new TreeNode(nums[mid]);
//        root.left = createNode(nums,left,mid - 1);
//        root.right = createNode(nums,mid + 1, right);
//        return root;
//    }
}
