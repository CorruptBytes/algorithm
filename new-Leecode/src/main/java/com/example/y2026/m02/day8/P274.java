package com.example.y2026.m02.day8;

import java.util.Arrays;

/**
 * <h1>H指数</h1>
 * <p>给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。</p>
 * <a href="https://leetcode.cn/problems/h-index">链接</a>
 *
 */
public class P274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int size = n - i;
            if (citations[i] <= size) h = citations[i];
            else {
                h = Math.max(h,size);
            }
        }
        return h;
    }


    public int hIndexV1(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            h = Math.max(h,Math.min(n - i,citations[i]));
        }
        return h;
    }
}
