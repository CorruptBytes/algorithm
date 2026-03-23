package com.example.y2026.m02.day18;

/**
 * <h1>Pow(x,n)</h1>
 * <p>实现 pow(x, n) ，即计算 x 的整数 n 次幂函数。</p>
 * <a href="https://leetcode.cn/problems/powx-n">链接</a>
 */
public class P50 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean flag = n > 0;
        n = Math.abs(n);
        double res = x;
        for (int i = 1; i < n; i++) {
            res *= x;
        }
        return flag ? res : 1 / res;
    }
}
