package com.example.day34;

import com.leecode.structure.TreeNode;

/**
 * <h1>翻转二叉树</h1>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 翻转即翻转每一个节点的左右孩子
 */
public class P226 {

    //简简单单秒了
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

}
