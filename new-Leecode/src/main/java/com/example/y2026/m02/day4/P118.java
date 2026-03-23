package com.example.y2026.m02.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>杨辉三角</h1>
 * <p>给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。</p>
 * <a href="https://leetcode.cn/problems/pascals-triangle/description/">链接</a>
 */
public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = List.of(1);
        res.add(prev);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    cur.add(1);
                } else {
                    cur.add(prev.get(j - 1) + prev.get(j));
                }
            }
            res.add(cur);
            prev = cur;
        }
        return res;
    }
}
