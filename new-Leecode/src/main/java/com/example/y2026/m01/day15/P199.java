package com.example.y2026.m01.day15;


import com.leecode.strucutre.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>二叉树的右视图</h1>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */

public class P199 {
    //层序遍历只添加最后一个结点
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            result.add(list.getLast().val);
            while (size-- > 0) {
                TreeNode node = list.removeFirst();
                if (node.left != null) list.addLast(node.left);
                if (node.right != null) list.addLast(node.right);
            }
        }
        return result;
    }

    public List<Integer> rightSideViewV1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }
    //递归搜索每层，从右侧开始找
    private void dfs(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        if (list.size() < level+1) {
            list.add(root.val);
        }
        dfs(root.right, list, level + 1);
        dfs(root.left, list, level + 1);
    }


}
