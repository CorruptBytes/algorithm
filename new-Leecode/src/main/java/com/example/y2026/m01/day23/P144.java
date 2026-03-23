package com.example.y2026.m01.day23;

import com.leecode.strucutre.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>二叉树的前序遍历</h1>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class P144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }
    public void preorderTraversal(TreeNode node,List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderTraversal(node.left,result);
        preorderTraversal(node.right,result);
    }
}
