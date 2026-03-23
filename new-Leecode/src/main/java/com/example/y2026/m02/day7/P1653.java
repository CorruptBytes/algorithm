package com.example.y2026.m02.day7;

/**
 * <h1>使字符串平衡的最少删除次数</h1>
 * <p>给你一个字符串 s ，它仅包含字符 'a' 和 'b'
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，
 * 此时认为 s 是 平衡 的。
 * 请你返回使 s 平衡 的 最少 删除次数。</p>
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/description/">链接</a>
 */
public class P1653 {
    //本质是将字符串分成两部分，删除左半部分的所有b，删除右半部分的所有a，可以穷举所有间隔的删除情况,字符串长度为n，一共n + 1种可能。
    public int minimumDeletions(String s) {
        int leftb = 0;
        int righta = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') righta++;
        }
        int res = righta;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                righta--;
            } else {
                leftb++;
            }
            res = Math.min(res,righta + leftb);
        }
        return res;
    }

}
