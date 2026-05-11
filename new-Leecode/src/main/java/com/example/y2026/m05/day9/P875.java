package com.example.y2026.m05.day9;

import java.security.Key;
import java.util.Arrays;

/**
 * <h1>爱吃香蕉的珂珂</h1>
 * <p>珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。</p>
 * <a href="https://leetcode.cn/problems/koko-eating-bananas">链接</a>
 */
public class P875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(piles,h,mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean check(int[] piles,int h, int k) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + k - 1) / k;
            time += curTime;
        }
        return time <= h;
    }
}
