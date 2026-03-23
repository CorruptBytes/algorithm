package com.example.y2026.m02.day4;

import com.leecode.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>路径总和Ⅲ</h1>
 * <p>给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</p>
 * <a href="https://leetcode.cn/problems/path-sum-iii/description/">链接</a>
 */
public class P437 {

    private int ans;
    public int pathSum(TreeNode root, int targetSum) {
        // key：从根到 node 的节点值之和
        // value：节点值之和的出现次数
        // 注意在递归过程中，哈希表只保存根到 node 的路径的前缀的节点值之和
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }

    // s 表示从根到 node 的父节点的节点值之和（node 的节点值尚未计入）
    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return;
        }

        s += node.val;
        // 把 node 当作路径的终点，统计有多少个起点
        ans += cnt.getOrDefault(s - targetSum, 0);

        cnt.merge(s, 1, Integer::sum); // cnt[s]++
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // cnt[s]-- 恢复现场（撤销 cnt[s]++）
    }
    public int pathSumV1(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSumV1(root.left, targetSum);
        ret += pathSumV1(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }


}
