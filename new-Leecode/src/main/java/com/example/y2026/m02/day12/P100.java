package com.example.y2026.m02.day12;


import com.example.structure.TreeNode;

/**
 * <h1>相同的树</h1>
 * <p>给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。</p>
 * <a href="https://leetcode.cn/problems/same-tree">链接</a>
 */
public class P100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
