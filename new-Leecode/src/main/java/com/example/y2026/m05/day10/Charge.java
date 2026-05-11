package com.example.y2026.m05.day10;

import java.awt.*;
import java.util.Scanner;

/**
 * <h1>机器人充电</h1>
 <p>
 在同一个数轴上有 <code>N</code> 个机器人和 <code>M</code> 个充电桩。
 </p>
 <ul>
 <li>第 <code>i</code> 个机器人位于位置：<code>ni</code></li>
 <li>第 <code>j</code> 个充电桩位于位置：<code>mj</code></li>
 <li>并且该充电桩最多可以为 <code>cj</code> 个机器人提供充电服务</li>
 </ul>
 <p>
 如果机器人与充电桩之间的距离不超过 <code>E</code>，
 则该机器人可以由该充电桩供电。
 </p>
 <p>
 现在你需要求出一个最小的整数 <code>E</code>，使得：
 </p>
 <p>
 <strong>
 所有机器人都能够被某个充电桩供电，
 并且任意充电桩服务的机器人数量不超过其容量限制。
 </strong>
 </p>
 <hr>
 <h3>输入格式</h3>
 <p>
 第一行输入两个整数：
 </p>
 <pre>
 N M
 </pre>
 <p>
 表示机器人数量和充电桩数量。
 </p>
 <p>
 第二行输入 <code>N</code> 个整数：
 </p>
 <pre>
 n1 n2 ... nN
 </pre>
 <p>
 表示所有机器人的位置。
 </p>
 <p>
 第三行输入 <code>M</code> 个整数：
 </p>
 <pre>
 m1 m2 ... mM
 </pre>
 <p>
 表示所有充电桩的位置。
 </p>
 <p>
 第四行输入 <code>M</code> 个整数：
 </p>
 <pre>
 c1 c2 ... cM
 </pre>
 <p>
 表示每个充电桩的容量。
 </p>
 <hr>
 <h3>输出格式</h3>
 <p>
 输出一个整数，表示最小的距离 <code>E</code>。
 </p>
 <p>
 如果无法覆盖所有机器人，输出：
 </p>

 <pre>
 -1
 </pre>
 */
public class Charge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] robots = new int[n];
        int[] chargers =new int[m];
        int[] cap = new int[m];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            robots[i] = sc.nextInt();
            max = Math.max(robots[i],max);
        }
        for (int i = 0; i < m; i++) {
            chargers[i] = sc.nextInt();
            max = Math.max(max,chargers[i]);
        }
        for (int i = 0; i < m; i++) {
            cap[i] = sc.nextInt();
            sum += cap[i];
        }
        if (sum < n) {
            System.out.println(-1);
            return;
        }
        //二分答案
        int l = 0;
        int r = max;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (check(robots,chargers,cap,mid)) {
                r = mid;
            } else  {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
    public static boolean check(int[] robots,int[] chargers, int[] cap, int radius) {
        int n = robots.length;
        int m = chargers.length;
        int i = 0;
        for (int j = 0; j < m; j++) {
            int charger = chargers[j];
            int capacity = cap[j];
            int min = charger - radius;
            int max = charger + radius;
            if (i < n && robots[i] < min) return false;
            while (i < n && capacity > 0 && min <= robots[i] && robots[i] <= max) {
                i++;
                capacity--;
            }
        }
        return i == n;
    }
































}
