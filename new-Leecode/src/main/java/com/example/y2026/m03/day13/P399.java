package com.example.y2026.m03.day13;

import java.util.*;

/**
 * <h1>除法求值</h1>
 * <p>给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。</p>
 * <a href="https://leetcode.cn/problems/evaluate-division">链接</a>
 */
public class P399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // 1 构建图
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] ans = new double[queries.size()];

        // 2 处理每个query
        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
            } else if (start.equals(end)) {
                ans[i] = 1.0;
            } else {
                ans[i] = dfs(graph, start, end, new HashSet<>());
            }
        }

        return ans;

    }

    private double dfs(Map<String, Map<String, Double>> graph,
                       String cur,
                       String target,
                       Set<String> visited) {

        if (graph.get(cur).containsKey(target)) {
            return graph.get(cur).get(target);
        }

        visited.add(cur);

        for (String next : graph.get(cur).keySet()) {

            if (visited.contains(next)) {
                continue;
            }

            double res = dfs(graph, next, target, visited);

            if (res != -1.0) {
                return graph.get(cur).get(next) * res;
            }
        }

        return -1.0;
    }

}
