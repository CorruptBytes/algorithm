package com.example.day28;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>二叉树的前序遍历</h1>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class P144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderTraversal(root,results);
        return results;
    }
    public void preorderTraversal(TreeNode root,List<Integer> results) {
        if (root == null) return;

        results.add(root.val);
        preorderTraversal(root.left,results);
        preorderTraversal(root.right,results);
    }
}
