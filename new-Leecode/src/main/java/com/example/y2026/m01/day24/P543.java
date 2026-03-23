package com.example.y2026.m01.day24;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>二叉树的直径</h1>
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class P543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getPath(root);
        return max;
    }
    //从下往上统计高度，不能从上往下统计深度
    public int getPath(TreeNode root) {
        if (root == null) return 0;
        int left = getPath(root.left);
        int right = getPath(root.right);
        max = Math.max(left + right,max);
        return Math.max(left,right) + 1;
    }
}
