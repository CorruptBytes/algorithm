package com.example.y2026.m01.day21;


import com.example.structure.TreeNode;

/**
 * <h1>对称二叉树</h1>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class P101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right);
    }

}
