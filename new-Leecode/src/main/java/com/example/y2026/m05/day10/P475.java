package com.example.y2026.m05.day10;

import java.util.Arrays;

/**
 * <h1>供暖器</h1>
 * <p>冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 注意：所有供暖器 heaters 都遵循你的半径标准，加热的半径也一样。</p>
 * <a href="https://leetcode.cn/problems/heaters">链接</a>
 */
public class P475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = Math.max(houses[houses.length - 1],heaters[heaters.length - 1]);
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (check(houses,heaters,mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] houses,int[] heaters,int radius) {
        int i = 0;
        int n = houses.length;
        for (int heater : heaters) {
            int min = heater - radius;
            int max = heater + radius;
            while (i < n && min <= houses[i] && houses[i] <= max) {
                i++;
            }
        }
        return i == n;
    }
}
