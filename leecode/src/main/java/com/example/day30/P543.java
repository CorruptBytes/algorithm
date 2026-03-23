package com.example.day30;

import com.leecode.structure.TreeNode;

/**
 * <h1>二叉树的直径</h1>
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class P543 {
    private int len = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(dfs(root) - 2,len - 2);
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left) + 1;
        int rightDepth = dfs(root.right) + 1;
        len  = Math.max(leftDepth + rightDepth,len);
        return Math.max(leftDepth,rightDepth);
    }

    public static void main(String[] args) {
        P543 test = new P543();
        System.out.println(Math.max(test.len,test.test()));
    }
    public int test() {
        len = 10;
        return 5;
    }
}
