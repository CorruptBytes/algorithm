package com.example.y2026.m01.day12;

import com.leecode.strucutre.TreeNode;

import java.util.*;

/**
 * <h1>二叉树的锯齿形层序遍历</h1>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class P103 {
    //本质不是锯齿状遍历，仍然是普通层序遍历，只是对结果的修正
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            LinkedList<Integer> temp = new LinkedList<>();
            //遍历顺序不变，改变添加数字的顺序
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                if (results.size() % 2 == 0) temp.addLast(node.val);
                else temp.addFirst(node.val);
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            results.add(temp);
        }
        return results;
    }
    //双栈
    public List<List<Integer>> zigzagLevelOrderV1(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> curr = new ArrayDeque<>();
        Deque<TreeNode> next = new ArrayDeque<>();

        curr.push(root);

        while (!curr.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!curr.isEmpty()) {
                TreeNode node = curr.pop();
                level.add(node.val);
                //利用栈先进后出的特性
                if (res.size() % 2 == 0) {
                    if (node.left != null) next.push(node.left);
                    if (node.right != null) next.push(node.right);
                } else {
                    if (node.right != null) next.push(node.right);
                    if (node.left != null) next.push(node.left);
                }
            }
            res.add(level);
            Deque<TreeNode> tmp = curr;
            curr = next;
            next = tmp;
        }

        return res;
    }

}
