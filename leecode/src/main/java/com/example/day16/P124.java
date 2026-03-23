package com.example.day16;

import com.leecode.structure.TreeNode;

/**
 * <h1>二叉树中的最大路径和</h1>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 */
public class P124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxValue(root);
        return maxSum;
    }
    public int maxValue(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftValue = Math.max(maxValue(node.left),0);
        int rightValue = Math.max(maxValue(node.right),0);
        int priceNewPath = node.val + leftValue + rightValue;
        maxSum = Math.max(priceNewPath,maxSum);
        return node.val + Math.max(leftValue,rightValue);
    }
}
