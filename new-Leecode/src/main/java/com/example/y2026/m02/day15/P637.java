package com.example.y2026.m02.day15;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>二叉树的层平均值</h1>
 * <p>给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。</p>
 * <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree">链接</a>
 */
public class P637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return List.of();
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            double divider = size;
            long sum = 0;
            while (size-- > 0) {
                TreeNode node = list.pop();
                sum += node.val;
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            res.add(sum / divider);
        }
        return res;
    }
}
