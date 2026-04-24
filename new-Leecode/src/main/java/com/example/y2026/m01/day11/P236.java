package com.example.y2026.m01.day11;



import com.example.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>二叉树的最近公共祖先</h1>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class P236 {
    private TreeNode ans;

    public P236() {
        this.ans = null;
    }
    //dfs寻找当前结点root的子树中是否具有p或q结点
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        //递归调用判断当前结点的左右子树中是否具有p或q结点
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        //当前结点为最近公共祖先有两种情况：该节点的左子树和右子树中分别有一个目标结点；该结点就是一个目标结点，且左右子树中存在另一个目标节点。
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
    //必须保证两个目标结点均存在，否则答案错误
    /*
        两种情况：
        p或q本身是另一个结点的祖先，此时先被遍历到的结点本身为答案
        p或q分别位于一个结点的左右子树，则这个结点为答案。
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        //找寻当前结点的左右子树是否存在p或q，不存在则会返回null
        TreeNode left = lowestCommonAncestorV1(root.left, p, q);
        TreeNode right = lowestCommonAncestorV1(root.right, p, q);
        //如果左子树不存在，则可能右子树存在(右子树也可能不存在，那会直接返回null),右子树不存在同理
        if (left == null) return right;
        if (right == null) return left;
        //左右子树均存在，说明当前结点就是目标结点，直接返回
        return root;
    }
    //回溯算法遍历找到子节点到根节点的路径，对比两个目标节点的路径，找到最深祖先节点。
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
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
