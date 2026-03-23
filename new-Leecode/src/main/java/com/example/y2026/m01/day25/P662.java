package com.example.y2026.m01.day25;

import com.leecode.strucutre.TreeNode;

import java.util.LinkedHashMap;
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
    /**
     * 对二叉树节点进行编号,根节点为1,左子节点为[根节点 * 2],右子节点为[根节点 * 2 + 1]
     * 根据每一层最左与最右节点的编号相减再加1，即可只这一层的宽度
     * @param root
     * @return
     */
    //层序遍历，效率较低
    public int widthOfBinaryTree(TreeNode root) {
        LinkedHashMap<TreeNode,Integer> map = new LinkedHashMap<>();
        if (root == null) return 0;
        map.putLast(root,1);
        int max = 1;
        while (!map.isEmpty()) {
            int width = map.lastEntry().getValue() - map.firstEntry().getValue() + 1;
            max = Math.max(max,width);
            int size = map.size();
            while (size-- > 0) {
                Map.Entry<TreeNode, Integer> entry = map.pollFirstEntry();
                TreeNode node = entry.getKey();
                int index = entry.getValue();
                if (node.left != null) {
                    map.putLast(node.left,index * 2);
                }
                if (node.right != null) {
                    map.putLast(node.right,index * 2 + 1);
                }
            }
        }
        return max;
    }
    //邪修
    static int[] firsts = new int[3001];
    int size = 0;
    int max = 0;
    public int widthOfBinaryTreeV1(TreeNode root) {
        dfs(root, 0, 0);
        return max + 1;
    }

    private void dfs(TreeNode node, int height, int index) {
        if (node == null) return;
        if (height == size)
            firsts[size++] = index;
        else
            max = Math.max(max, index - firsts[height]);
        dfs(node.left, height + 1, 2 * index + 1);
        dfs(node.right, height + 1, 2 * index + 2);
    }


}
