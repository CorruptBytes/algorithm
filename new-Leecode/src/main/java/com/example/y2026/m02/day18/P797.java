package com.example.y2026.m02.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>所有可能的路径</h1>
 * <p>给你一个有 n 个节点的 有向无环图（DAG），请你找出从节点 0 到节点 n-1 的所有路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。</p>
 *  <a href="https://leetcode.cn/problems/all-paths-from-source-to-target">链接</a>
 */
public class P797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path.add(0);
        used[0] = true;
        dfs(0,n - 1,used,graph,path,res);
        return res;
    }

    public void dfs(int node,int n,boolean[] used,int[][] graph,List<Integer> path,List<List<Integer>> res) {
        if (node == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            if (used[nextNode]) continue;
            path.add(nextNode);
            used[nextNode] = true;
            dfs(nextNode,n,used,graph,path,res);
            used[nextNode] = false;
            path.removeLast();
        }
    }
}
