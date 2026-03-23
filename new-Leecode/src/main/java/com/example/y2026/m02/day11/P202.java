package com.example.y2026.m02.day11;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>快乐数</h1>
 * <p>编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。</p>
 * <a href="https://leetcode.cn/problems/happy-number">链接</a>
 */
public class P202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int res = n;
        while (set.add(res)) {
            int temp = res;
            res = 0;
            while (temp > 0) {
                res += (temp % 10) * (temp % 10);
                temp /= 10;
            }
            if (res == 1) return true;
        }
        return false;
    }
}
