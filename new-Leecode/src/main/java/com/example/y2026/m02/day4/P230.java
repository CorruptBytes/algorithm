package com.example.y2026.m02.day4;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>二叉搜索树中第K小的元素</h1>
 * <p>给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。</p>
 * <a href="">链接</a>
 */
public class P230 {
    private int count;
    private int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        traversal(root.right);
    }

}
