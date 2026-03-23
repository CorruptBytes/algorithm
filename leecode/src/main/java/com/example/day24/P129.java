package com.example.day24;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>求根节点到叶节点数字之和</h1>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class P129 {
    //通过List保存每一个元素，最后求和
    public int sumNumbers(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        backtracking(root,0,results);
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    private void backtracking(TreeNode root, int num, List<Integer> results) {
        if (root.left == null && root.right == null) {
            results.add(num * 10 + root.val);
            return;
        }
        if (root.left != null) {
            backtracking(root.left,num * 10 + root.val,results);
        }
        if (root.right != null) {
            backtracking(root.right,num * 10 + root.val,results);
        }
    }

    //可以舍弃List，直接在递归中求解和
//    public int sumNumbers(TreeNode root) {
//       return backtracking(root,0);;
//    }

    private int backtracking(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        int temp = num * 10 + root.val;
        if (root.left == null && root .right == null) {
            return temp;
        }
        return backtracking(root.left, temp) + backtracking(root.right, temp);
    }

}
