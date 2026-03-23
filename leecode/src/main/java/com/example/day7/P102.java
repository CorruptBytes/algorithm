package com.example.day7;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class P102 {
    
    //第一个方式,通过双向链表模拟栈来进行层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        //创建双向链表模拟栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int levelSize = 1;
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            while (levelSize != 0) {
                TreeNode node = stack.removeFirst();
                levelList.add(node.val);
                levelSize--;
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            list.add(levelList);
            levelSize = stack.size();

        }
        return list;
    }
}
