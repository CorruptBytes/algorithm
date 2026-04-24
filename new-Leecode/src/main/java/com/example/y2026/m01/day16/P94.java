package com.example.y2026.m01.day16;




import com.example.structure.TreeNode;

import java.util.*;

/**
 * <h1>二叉树的中序遍历</h1>
 * <p>给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。</p>
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal">链接</a>
 * <p>进阶：递归算法很简单，你可以通过迭代算法完成吗？</p>
 */
public class P94 {
    //递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return result;
    }
    public void traversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traversal(node.left,result);
        result.add(node.val);
        traversal(node.right,result);
    }

    //迭代实现,感觉可以使用栈
    public List<Integer> inorderTraversalV1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null ||!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root =root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
