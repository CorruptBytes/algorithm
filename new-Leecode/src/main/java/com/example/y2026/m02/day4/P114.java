package com.example.y2026.m02.day4;

import com.example.structure.TreeNode;

/**
 * <h1>二叉树展开为链表</h1>
 * <p> 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *  展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 *  展开后的单链表应该与二叉树 先序遍历 顺序相同。</p>
 *  <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/">链接</a>
 */
public class P114 {
    //中序遍历，从下往上合并
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tail = root.right;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = temp;
        }
        flatten(root.right);
    }

    //从上往下合并
    private TreeNode tail;
    public void flattenV1(TreeNode root) {
        if (root == null) return;
        tail = root;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        flattenV1(root.right);
        tail.right = right;
        flattenV1(right);
    }

}
