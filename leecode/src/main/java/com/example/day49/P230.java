package com.example.day49;

import com.leecode.structure.TreeNode;

/**
 * <h1>二叉搜索树中第K小的元素</h1>
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 */
public class P230 {
    private TreeNode target;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k - 1;
        findNode(root);
        return target.val;
    }

    //中序遍历
//    public void findNode(TreeNode root) {
//       if (root == null) return;
//       findNode(root.left);
//       if (count == 0) {
//           target = root;
//       }
//       count--;
//       findNode(root.right);
//    }
    public boolean findNode(TreeNode root) {
        if (root == null) return false;

        if (findNode(root.left)) return true;

        if (count-- == 0) {
            target = root;
            return true;
        }

        return findNode(root.right);
    }

}
