package com.example.y2026.m01.day16;


import com.leecode.strucutre.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>二叉树的中序遍历</h1>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class P94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return result;
    }
    public void traversal(TreeNode node,List<Integer> result) {
        if (node == null) return;
        traversal(node.left,result);
        result.add(node.val);
        traversal(node.right,result);
    }
}
