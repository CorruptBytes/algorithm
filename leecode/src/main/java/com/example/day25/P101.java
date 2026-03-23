package com.example.day25;

import com.leecode.structure.TreeNode;

/**
 * <h1>对称二叉树</h1>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class P101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left,root.right);
    }
    private boolean compare(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return compare(left.left , right.right) && compare(left.right,right.left);
    }
}

