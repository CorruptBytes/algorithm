package com.example.y2026.m04.day16;
/**
 * <h1>直线上最多的点数</h1>
 */
public class P149 {
    public int maxPoints(int[] points) {
        Map<String,Integer> map = new HashMap<>();
    }

    public int[] getLine(int[] point1, int[] point2) {
        /*
        y = ax + b
        y1 = ax1 + b
        y2 = ax2 + b
        a = (y1 - y2) / (x1 - x2)
        b = y1 - ax1 */
        if (point1[0] == point2[0]) {
            
        }
        int a = (point1[1] - point2[1]) / (point1[0] - point2[0]);

    }
}
