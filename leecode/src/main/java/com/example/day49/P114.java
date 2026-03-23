package com.example.day49;

import com.leecode.structure.TreeNode;

/**
 * <h1>二叉树展开为链表</h1>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class P114 {
    //先照着简单的来，直接空间复杂度O(n)
    //    private LinkedList<TreeNode> list = new LinkedList<>();
    //    public void flatten(TreeNode root) {
    //        findNextNode(root);
    //        TreeNode pre = list.pollFirst();
    //        while (!list.isEmpty()) {
    //            TreeNode node = list.pop();
    //            pre.right = node;
    //            pre.left = null;
    //            pre = node;
    //        }
    //    }
    //    public void findNextNode(TreeNode root) {
    //        if (root == null) return;
    //        list.add(root);
    //        findNextNode(root.left);
    //        findNextNode(root.right);
    //    }
    private TreeNode tail;
    public void flatten(TreeNode root) {
        if (root == null) return;
        tail = root;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        flatten(root.right);
        tail.right = right;
        flatten(right);
    }


}
