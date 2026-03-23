package com.example.y2026.m01.day26;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>路径总和</h1>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class P112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        boolean left = false;
        if (root.left != null) {
            left = hasPathSum(root.left,targetSum);
        }
        boolean right = false;
        if (root.right != null) {
            right = hasPathSum(root.right,targetSum);
        }
        return left || right;
    }
}
