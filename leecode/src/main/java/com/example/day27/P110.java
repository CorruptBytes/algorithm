package com.example.day27;

import com.leecode.structure.TreeNode;

/**
 * <h1>平衡二叉树</h1>
 * 给定一个二叉树，判断它是否是 平衡二叉树
 */
public class P110 {
    //尝试递归
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left,right) + 1;
    }

}
