package com.example.day23;

import com.leecode.structure.TreeNode;

import java.util.Arrays;

/**
 * <h1>从前序与中序遍历序列构造二叉树</h1>
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class P105 {
    /*
    前序:3,9,20,15,7
    中序:9,3,15,20,7
     */
    //直接复制数组递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createNode(preorder,inorder);
    }

    private TreeNode createNode(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int inorderIndex = 0;
        for (; inorderIndex < inorder.length; inorderIndex++) {
            if (inorder[inorderIndex] == preorder[0]) {
                break;
            }
        }
        root.left = createNode(Arrays.copyOfRange(preorder,1,1 + inorderIndex), Arrays.copyOfRange(inorder,0,inorderIndex));
        root.right = createNode(Arrays.copyOfRange(preorder,1 + inorderIndex,preorder.length),Arrays.copyOfRange(inorder,inorderIndex + 1,inorder.length));
        return root;
    }
    //原地通过左边界与右边界对数组进行分界
    /**
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createNode(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }
     */
    //索引为左闭右闭
    private TreeNode createNode(int[] preorder,int pLeft,int pRight, int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        int inorderIndex = iLeft;
        for (; inorderIndex <= iRight; inorderIndex++) {
            if (inorder[inorderIndex] == preorder[pLeft]) {
                break;
            }
        }
        int len = inorderIndex - iLeft;
        root.left = createNode(preorder,pLeft + 1,pLeft + len,inorder,iLeft,inorderIndex - 1);
        root.right = createNode(preorder,pLeft + len + 1,pRight,inorder,inorderIndex + 1,iRight);
        return root;
    }
}
