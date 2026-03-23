package com.example.day34;

import com.leecode.structure.TreeNode;

/**
 * <h1>路径总和</h1>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class P112 {
    //回溯 不对，不需要回溯，直接递归找子节点就可以
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        boolean left = root.left != null && hasPathSum(root.left, targetSum - root.val);
        boolean right = root.right != null && hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }
    //copy一个以前写的回溯，怎么写的这么傻逼
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        return backtracking(root,targetSum,root.val);
//    }
    public boolean backtracking(TreeNode node, int targetSum, int sum) {
        if (node.left == null && node.right == null && sum == targetSum) {
            return true;
        }
        boolean left = false;
        if (node.left != null) {
            left = backtracking(node.left,targetSum,sum + node.left.val);
        }
        boolean right = false;
        if (node.right != null) {
            right = backtracking(node.right,targetSum,sum + node.right.val);
        }
        return left || right;
    }
}
