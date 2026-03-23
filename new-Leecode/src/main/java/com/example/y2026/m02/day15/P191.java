package com.example.y2026.m02.day15;

/**
 * <h1>位1的个数</h1>
 * <p>给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。</p>
 * <a href="https://leetcode.cn/problems/number-of-1-bits">链接</a>
 */
public class P191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}
