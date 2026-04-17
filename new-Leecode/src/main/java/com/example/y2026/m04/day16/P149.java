package com.example.y2026.m04.day16;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>直线上最多的点数</h1>
 */
public class P149 {
    public int maxPoints(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        int len = points.length;
        int maxCnt = 0;
        for (int i = 0; i < len; i++) {
            // 剪枝
            if (maxCnt >= len - i || maxCnt > len / 2) {
                break;
            }
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < len; j++) {
                // 处理斜率不存在的情况
                if (points[i][0] == points[j][0]) {
                    // 直接map的key用null代替
                    map.put(null, map.getOrDefault(null, 0) + 1);
                } else if (points[i][1] == points[j][1]) {
                    // 精度问题，斜率为0的也单独处理
                    map.put(0d, map.getOrDefault(0d, 0) + 1);
                }else {
                    double k = (double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    map.put(k, map.getOrDefault(k, 0) + 1);
                }
            }
            for (Integer value : map.values()) {
                maxCnt = Math.max(maxCnt, value + 1);
            }
        }
        return maxCnt;

    }

}
