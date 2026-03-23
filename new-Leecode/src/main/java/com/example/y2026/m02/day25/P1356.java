package com.example.y2026.m02.day25;

import java.util.*;

/**
 * <h1>根据二进制下的数字1的数目排序</h1>
 * <p>给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。</p>
 * <a href="https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits">链接</a>
 */
public class P1356 {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((a,b) -> {
            int ca = Integer.bitCount(a);
            int cb = Integer.bitCount(b);
            return ca == cb ? a - b : ca - cb;
        }).mapToInt(Integer::intValue).toArray();
    }
    public int[] sortByBitsV1(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
        }
        int[] bit = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
