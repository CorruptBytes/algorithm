package com.example.day11;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class P236 {
    //回溯算法遍历找到子节点到根节点的路径，对比两个目标节点的路径，找到最深祖先节点。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = new ArrayList<>();
        ArrayList<TreeNode> listQ = new ArrayList<>();
        try {
            traversal(root,p,listP);
        }catch (Exception ignored) {

        }
        try {
            traversal(root,q,listQ);
        }catch (Exception ignored) {

        }
        int size= Math.min(listP.size(),listQ.size());
        for (int i = size - 1; i >= 0; i--) {
            if (listP.get(i).val == listQ.get(i).val) {
                return listP.get(i);
            }
        }
        return null;
    }
    public void traversal(TreeNode node, TreeNode targetNode, List<TreeNode> list) throws Exception {
        if (node == null) {
            return;
        }
        if (node.val == targetNode.val) {
            list.add(node);
            throw new Exception();
        }
        list.add(node);
        traversal(node.left,targetNode,list);
        traversal(node.right,targetNode,list);
        list.removeLast();

    }
}
