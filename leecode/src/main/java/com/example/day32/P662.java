package com.example.day32;

import com.leecode.structure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <h1>二叉树最大宽度</h1>
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 */
public class P662 {
    //二叉树父子节点间存在索引关系(假设根节点索引为1),则左孩子的索引为父节点 * 2，右孩子索引为父节点 * 2 + 1
    //对二叉树进行层序遍历，找到每一层的最小索引和最大索引。
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode,Integer> map = new HashMap<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        map.put(root,1);
        int max = 1;
        while (!list.isEmpty()) {
            int size = list.size();
            TreeNode first = list.getFirst();
            TreeNode last = list.getLast();
            Integer start = map.get(first);
            Integer end = map.get(last);
            max = Math.max(end - start + 1,max);
            while (size > 0) {
                TreeNode node = list.removeFirst();
                Integer index = map.get(node);
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
        return max;
    }

    public static void main(String[] args) {
        System.out.println(1 + 1 << 1);
    }
}
