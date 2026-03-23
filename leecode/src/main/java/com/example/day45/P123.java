package com.example.day45;

/**
 * <h1>买卖股票的最佳时机Ⅲ</h1>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class P123 {

    public int maxProfitV1(int[] prices) {
        int n = prices.length;
        int[] profit = new int[n];
        int min = prices[0];
        int curp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                curp = Math.max(curp,prices[i] - min);
            }
            profit[i] = curp;
        }
        int res = 0;
        int max = prices[n-1];
        curp = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                int temp = max - prices[i];
                if (temp > curp) {
                    curp = temp;
                    res = Math.max(res,curp + profit[i]);
                }
            }
        }
        return res;
    }
    //动态规划，看不明白
    public int maxProfitV2(int[] prices) {
        int n = prices.length;
        int buy1 = prices[0], sell1 = 0;
        int buy2 = prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }



}
