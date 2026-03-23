package com.example.day47;

import com.leecode.structure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <h1>二叉树的完全性检验</h1>
 *
 * 给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
 *
 * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，
 * 并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2^h 个节点。
 */
public class P958 {
    //尝试层序遍历,为二叉树节点编号,如果编号不连续则说明二叉树不是完全二叉树
    //byd超越百分之2.5给哥们看笑了
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<TreeNode,Integer> map = new HashMap<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        map.put(root,1);
        int preIndex = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                TreeNode node = list.removeFirst();
                Integer index = map.get(node);
                if (index != preIndex + 1) {
                    return false;
                } else {
                    preIndex = index;
                }
                if (node.left != null) {
                    list.addLast(node.left);
                    map.put(node.left,index << 1);
                }
                if (node.right != null) {
                    list.addLast(node.right);
                    map.put(node.right,(index << 1) + 1);
                }
                size--;
            }
        }
        return true;
    }
    //感觉不需要Map存储二叉树序号,只需要层序遍历二叉树，如果遍历到空节点，判断空节点的下一个节点是否也为空节点即可。
    public boolean isCompleteTreeV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) {
                TreeNode node = list.poll();
                if (node == null) {
                    if (list.peek() != null) {
                        return false;
                    }
                } else {
                    list.add(node.left);
                    list.add(node.right);
                }
                size--;
            }
        }
        return true;
    }
}
