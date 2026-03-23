package com.example.day18;

import com.leecode.structure.TreeNode;

import java.util.*;

/**
 * <h1>二叉树的右视图</h1>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class P199 {
    //层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        list.add(root);
        int levelSize = 1;
        while (!list.isEmpty()) {
            while (levelSize > 0) {
                TreeNode node = list.removeFirst();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                if (levelSize == 1) {
                    result.add(node.val);
                }
                levelSize--;
            }
            levelSize = list.size();
        }
        return result;
    }
}
