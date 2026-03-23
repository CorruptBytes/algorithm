package com.example.y2026.m02.day9;

import com.leecode.strucutre.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>将二叉搜索树变平衡</h1>
 * <p>给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，
 * 新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。</p>
 * <a href="https://leetcode.cn/problems/balance-a-binary-search-tree/description">链接</a>
 */
public class P1382 {
    //先中序遍历搜索树，获得节点的有序集合后，重新构造搜索树。
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        traversal(root,list);
        return createTree(list,0,list.size() - 1);
    }

    public void traversal(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        traversal(root.left,list);
        list.add(root);
        traversal(root.right,list);

    }
    public TreeNode createTree(List<TreeNode> list,int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start ) / 2;
        TreeNode root = list.get(mid);
        root.left = createTree(list,start,mid - 1);
        root.right = createTree(list,mid + 1,end);
        return root;
    }
}
