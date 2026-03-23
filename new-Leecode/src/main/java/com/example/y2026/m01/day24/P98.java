package com.example.y2026.m01.day24;

import com.leecode.strucutre.TreeNode;

/**
 * <h1>验证二叉搜索树</h1>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * <li>节点的左子树只包含 严格小于 当前节点的数。</li>
 * <li>节点的右子树只包含 严格大于 当前节点的数。</li>
 * <li>所有左子树和右子树自身必须也是二叉搜索树。</li>
 */
public class P98 {

    //二叉搜索树的中序遍历为一个递增序列。
    TreeNode pre = null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        return isValid;
    }
    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre == null || root.val > pre.val) {
           pre = root;
        } else {
            isValid = false;
            return;
        }
        traversal(root.right);
    }

    //另一种写法，递归返回值作为结果，无需全局变量
    public boolean isValidBSTV1(TreeNode root) {
        TreeNode[] pre = new TreeNode[1];
        return next(root,pre);
    }
    public boolean next(TreeNode root,TreeNode[] pre) {
        if (root == null) {
            return true;
        }
        boolean left = next(root.left,pre);
        if (pre[0] != null && pre[0].val >= root.val) {
            return false;
        }
        pre[0] = root;
        boolean right = next(root.right,pre);
        return left && right;
    }
}
