package com.example.y2026.m01.day20;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>求根节点到叶节点数字之和</h1>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class P129 {
    //感觉可以递归
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        getVal(root,0);
        return sum;
    }
    //要注意只有到达叶子结点才能收集
    public void getVal(TreeNode root,int val) {
        if (root == null) return;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        getVal(root.left,val);
        getVal(root.right,val);
    }



}
