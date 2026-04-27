package com.example.y2026.m01.day20;


import com.example.structure.TreeNode;

/**
 * <h1>从前序与中序遍历序列构造二叉树</h1>
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class P105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createNode(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }

    private TreeNode createNode(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1) return null;
        int val = preorder[start1];
        TreeNode root = new TreeNode(val);
        int index = start2;
        while (index <= end2) {
            if (inorder[index] == val) {
                break;
            }
            index++;
        }
        int len = index - start2;
        root.left = createNode(preorder,start1 + 1,start1 + len,inorder,start2,index - 1);
        root.right = createNode(preorder,start1 + len + 1,end1,inorder,index + 1,end2);
        return root;
    }
}
