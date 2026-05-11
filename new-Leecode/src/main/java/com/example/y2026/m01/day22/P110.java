package com.example.y2026.m01.day22;



/**
 * <h1>平衡二叉树</h1>
 * 给定一个二叉树，判断它是否是 平衡二叉树
 */
public class P110 {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    //递归计算每一个结点的高度，左右结点的高度差大于1，就返回-1
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        //当前结点的父节点的高度应该是当前结点的左右结点的最大高度+当前结点
        return Math.max(left,right) + 1;
    }

}
