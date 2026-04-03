package com.example.y2026.m04.day2;

import java.util.PriorityQueue;

/**
 * <h1>机器人可以获得的 最大金币数</h1>
 * <p>给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右或向下移动。
 *
 * 网格中的每个单元格包含一个值 coins[i][j]：
 *
 * 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。
 * 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。
 * 机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。
 *
 * 注意：机器人的总金币数可以是负数。
 *
 * 返回机器人在路径上可以获得的 最大金币数 。</p>
 *
 * <a href="https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn">链接</a>
 */
public class P3418 {
    //使用堆维护机器人走过的所有负数格子，当到达终点时取出最小的两个加回去
    //超时
    public int maximumAmount(int[][] coins) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        dfs(coins,queue,0,0,0);
        return max;
    }
    int max = Integer.MIN_VALUE;
    public void dfs(int[][] coins, PriorityQueue<Integer> queue, int i, int j, int sum) {
        int m = coins.length;
        int n = coins[0].length;
        if (i >= m || j >= n) return;
        int cur = coins[i][j];
        if (cur < 0) {
            queue.add(cur);
        }
        sum += cur;
        if (i == m - 1 && j == n - 1) {
            Integer n1 = null,n2 = null;
            if (!queue.isEmpty()) n1 = queue.poll();
            if (!queue.isEmpty()) n2 = queue.poll();
            if (n1 != null) {
                sum -= n1;
                queue.add(n1);
            }
            if (n2 != null) {
                sum -= n2;
                queue.add(n2);
            }
            max = Math.max(max,sum);
        }
        dfs(coins,queue,i + 1,j,sum);
        dfs(coins,queue,i , j + 1,sum);
        if (cur < 0) queue.remove(cur);
    }
}
