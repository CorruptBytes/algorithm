package com.example.y2026.m01.day13;

import javax.swing.plaf.synth.ColorType;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>合并区间</h1>
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class P56 {
    //使用List，非原地合并，效率有点低，感觉可以改为原地
    public int[][] merge(int[][] intervals) {
        //先排序
        Arrays.sort(intervals,(a1,a2)-> {
            if (a1[0] != a2[0]) return a1[0] - a2[0];
            return a1[1] - a2[1];
        });
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (i == 0) {
                result.add(interval);
                continue;
            }
            int[] last = result.getLast();
            //因为已经对数组进行排序，所以只要比较当前区间的start是否小于等于合并后的最后一个区间的end，如果是则说明重叠可以合并
            if (last[1] >= interval[0]) {
                last[1] = Math.max(interval[1],last[1]);
            } else {
                result.add(interval);
            }
        }
        return result.toArray(new int[0][2]);
    }

    public int[][] mergeV1(int[][] intervals) {
        //先排序
        Arrays.sort(intervals,(a1,a2)-> {
            return a1[0] - a2[0];
        });
        int size = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = intervals[size - 1];
            //因为已经对数组进行排序，所以只要比较当前区间的start是否小于等于合并后的最后一个区间的end，如果是则说明重叠可以合并
            if (last[1] >= interval[0]) {
                last[1] = Math.max(interval[1],last[1]);
            } else {
                intervals[size++] = interval;
            }
        }
        int[][] results = new int[size][2];
        System.arraycopy(intervals,0,results,0,size);
        return results;
    }
}
