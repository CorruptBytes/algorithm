package com.example.y2026.m01.day15;


import com.example.structure.TreeNode;

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
    //递归搜索每层，从右侧开始找，只添加每一层第一个遍历到的节点，由于是优先从右侧开始找，该节点一定是最右侧的节点。
    private void dfs(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(root.val);
        }
        dfs(root.right, list, level + 1);
        dfs(root.left, list, level + 1);
    }

    public List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,0,res);
        return res;
    }
    //先序遍历，先遍历左侧，之后再遍历右侧，最终当前层的节点会覆盖为最右侧的节点
    public void traversal(TreeNode root,int level,List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);     // 第一次到这一层
        } else {
            res.set(level, root.val); // 覆盖成更右的
        }
        traversal(root.left,level + 1,res);
        traversal(root.right,level + 1,res);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tail = root.right;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = temp;
        }
        flatten(root.right);
    }

}
