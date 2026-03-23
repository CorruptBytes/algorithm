package com.example.y2026.m02.day27;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * <h1>使二进制字符串全为1的最少操作次数</h1>
 * <p>给你一个二进制字符串 s 和一个整数 k。
 * 在一次操作中，你必须选择 恰好 k 个 不同的 下标，并将每个 '0' 翻转 为 '1'，每个 '1' 翻转为 '0'。
 * 返回使字符串中所有字符都等于 '1' 所需的 最少 操作次数。如果不可能，则返回 -1</p>
 * <a href="https://leetcode.cn/problems/minimum-operations-to-equalize-binary-string">链接</a>
 */
public class P3666 {

    public int minOperations(String s, int k) {
        int n = s.length();

        // 统计初始 0 的数量
        int z = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') z++;
        }

        // 如果已经是全 1
        if (z == 0) return 0;

        // 如果 k > n 不可能
        if (k > n) return -1;

        // dist 数组
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // 两个集合：存未访问状态
        TreeSet<Integer> evenSet = new TreeSet<>();
        TreeSet<Integer> oddSet = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) evenSet.add(i);
            else oddSet.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();

        // 初始化
        queue.offer(z);
        dist[z] = 0;
        if (z % 2 == 0) evenSet.remove(z);
        else oddSet.remove(z);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 计算 i 的范围
            int minI = Math.max(0, k - (n - cur));
            int maxI = Math.min(k, cur);

            if (minI > maxI) continue;

            // 对应 z' 的范围
            int L = cur + k - 2 * maxI;
            int R = cur + k - 2 * minI;

            // 目标奇偶性
            int targetParity = (cur + k) % 2;

            TreeSet<Integer> targetSet =
                    (targetParity == 0) ? evenSet : oddSet;

            // 找到 >= L 的第一个
            Integer next = targetSet.ceiling(L);

            while (next != null && next <= R) {
                int nxt = next;

                dist[nxt] = dist[cur] + 1;
                queue.offer(nxt);

                targetSet.remove(nxt);

                next = targetSet.ceiling(L);
            }
        }

        return dist[0];
    }
}
