package com.example.day27;

import com.leecode.structure.TreeNode;

/**
 * <h1>二叉树的最大深度</h1>
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class P104 {
    //递归尝试
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMaxDepth(root);
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left) + 1,getMaxDepth(root.right) + 1);
    }
}
