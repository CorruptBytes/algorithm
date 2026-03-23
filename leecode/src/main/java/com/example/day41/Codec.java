package com.example.day41;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <h1>二叉树的序列化与反序列化</h1>
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class Codec {
    /**
     * 先按照力扣的模式序列化,层序遍历，然后再按照层构造二叉树
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "n";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        sb.append(root.val);
        int size = 1;
        while (!list.isEmpty()) {
            while (size > 0) {
                TreeNode node = list.removeFirst();
                if (node.left == null) {
                    sb.append(",n");
                } else {
                    sb.append(",").append(node.left.val);
                    list.addLast(node.left);
                }
                if (node.right == null) {
                    sb.append(",n");
                } else {
                    sb.append(",").append(node.right.val);
                    list.addLast(node.right);
                }
                size--;
            }
            size = list.size();
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("n")) return null;
        String[] strings = data.split(",");
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        list.addLast(root);
        int index = 1;
        while (index < strings.length) {
            int size = list.size();
            while (size > 0) {
                TreeNode node = list.removeFirst();
                if (strings[index].equals("n")) {
                    node.left = null;
                } else {
                    TreeNode left = new TreeNode(Integer.parseInt(strings[index]));
                    node.left = left ;
                    list.addLast(left);
                }
                index++;
                if (strings[index].equals("n")) {
                    node.right = null;
                } else {
                    TreeNode left = new TreeNode(Integer.parseInt(strings[index]));
                    node.right = left ;
                    list.addLast(left);
                }
                index++;
                size--;
            }
        }
        return root;
    }

}
