package com.example.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>合并区间</h1>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class P56 {


    //先对数组进行排序，然后遍历数组合并区间
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if ( intervals[i][0] > right) {
                list.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(right,intervals[i][1]);
            }
        }
        list.add(new int[]{left,right});
        return list.toArray(new int[0][2]);
    }
}
