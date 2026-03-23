package com.example.y2026.m02.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>插入区间</h1>
 * <p>给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，
 * 其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 * 并且 intervals 按照 starti 升序排列。
 * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * 在 intervals 中插入区间 newInterval，
 * 使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。</p>
 * <a href="https://leetcode.cn/problems/insert-interval">链接</a>
 */
public class P57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) return new int[][] {newInterval};
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (flag && (intervals[i][0] > newInterval[0] || (intervals[i][0] == newInterval[0] && intervals[i][1] > newInterval[1]))) {
                res.add(newInterval);
                flag = false;
            }
            res.add(intervals[i]);
        }
        if (flag) {
            res.add(newInterval);
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0 ; i < res.size() ; i++) {
            int[] interval = res.get(i);
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
}
