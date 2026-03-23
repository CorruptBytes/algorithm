package com.example.y2026.m01.day14;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>二叉树中的最大路径和</h1>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 */
public class P124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getPathSum(root);
        return max;
    }
    //方法用于向上返回当前结点与其子节点中的最大路径值之和,如果路径和小于0，直接返回0，因为它对上层节点的路径和没有增益，可以直接舍弃。
    public int getPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = getPathSum(root.left);
        int right = getPathSum(root.right);
        //先算左右子树路径与根节点加起来的路径和，因为这种路径和无法向上传递
        max = Math.max(left + right + root.val,max);
        //再算当前结点与其子节点中的最大路径值之和。
        int maxPath = Math.max(left,right) + root.val;
        max = Math.max(maxPath,max);
        //最后向上返回当前结点与其子节点中的最大路径值之和
        return Math.max(maxPath, 0);
    }

    //与第一种方法思路一致，但是代码更简洁。
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSumV1(TreeNode root) {
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
