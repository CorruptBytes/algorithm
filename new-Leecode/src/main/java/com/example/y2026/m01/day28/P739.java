package com.example.y2026.m01.day28;
/**
 * <h1>每日温度</h1>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class P739 {
    //从后往前求，可以使用后面的结果简化前面元素的计算。
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int cur = temperatures[i];
            for (int j =i + 1; j < n; j += res[j]) {
                if (cur >= temperatures[j]) {
                    if (res[j] == 0) break;
                } else {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
