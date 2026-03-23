package com.example.day32;

import com.leecode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>路经总和Ⅱ</h1>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class P113 {
    //回溯
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        backtracking(root,targetSum,root.val,results,result);
        return results;
    }

    public void backtracking(TreeNode root,int targetSum,int sum,List<List<Integer>> results,List<Integer> result) {
        if (root.left == null && root.right == null && sum == targetSum) {
            results.add(new ArrayList<>(result));
            return;
        }

        if (root.left != null) {
            result.add(root.left.val);
            backtracking(root.left,targetSum,sum + root.left.val,results,result);
            result.removeLast();
        }
        if (root.right != null) {
            result.add(root.right.val);
            backtracking(root.right,targetSum,sum + root.right.val,results,result);
            result.removeLast();
        }
    }
}
