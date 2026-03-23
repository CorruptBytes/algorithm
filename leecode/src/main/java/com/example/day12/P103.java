package com.example.day12;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，
 * 返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class P103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int levelSize = 1;
        boolean isAsc = true;
        while (!list.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            if (isAsc) {
                while (levelSize != 0) {
                    TreeNode node = list.remove();
                    result.add(node.val);
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                    levelSize--;
                }

            } else {
                while (levelSize != 0) {
                    TreeNode node = list.removeLast();
                    result.add(node.val);
                    if (node.right != null) {
                        list.addFirst(node.right);
                    }
                    if (node.left != null) {
                        list.addFirst(node.left);
                    }
                    levelSize--;
                }
            }
            results.add(result);
            levelSize = list.size();
            isAsc = !isAsc;
        }
        return results;
    }
}
