package com.example.y2026.m02.day3;

import java.util.LinkedList;

import com.example.structure.TreeNode;

/**
 * <h1>二叉树的完全性检验</h1>
 * <p>
 *  给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
 *  在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，
 *  并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2^h 个节点。</p>
 *  <a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/">链接</a>
 */
public class P958 {

    //感觉不需要Map存储二叉树序号,只需要层序遍历二叉树，如果遍历到空节点，判断空节点的下一个节点是否也为空节点即可。
    //对于完全二叉树，空节点的下一个节点一定是null
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                TreeNode node = list.poll();
                if (node == null) {
                    if (list.peek() != null) {
                        return false;
                    }
                } else {
                    list.add(node.left);
                    list.add(node.right);
                }
                size--;
            }
        }
        return true;
    }
}
