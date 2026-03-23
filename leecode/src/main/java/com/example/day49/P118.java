package com.example.day49;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>杨辉三角</h1>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        list.add(new ArrayList<>(List.of(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int index = 0; index < i + 1; index++) {
                if (index == 0 || index == i) {
                    row.add(1);
                } else {
                    row.add(list.get(i - 1).get(index - 1) + list.get(i - 1).get(index));
                }
            }
            list.add(row);
        }
        return list;
    }
}
