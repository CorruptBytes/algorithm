package com.example.y2026.m01.day22;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>二叉树的最大深度</h1>
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class P104 {

    public int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }
    //从上往下统计
    public int maxDepth(TreeNode node,int cur) {
        if (node == null) return cur;
        cur++;
        int left = maxDepth(node.left,cur);
        int right = maxDepth(node.right,cur);
        return Math.max(left,right);
    }

    public int maxDepthV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMaxDepth(root);
    }
    //从下往上统计
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left),getMaxDepth(root.right)) + 1;
    }

    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

}
