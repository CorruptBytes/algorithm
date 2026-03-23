package com.example.y2026.m01.day31;
/**
 * <h1>买卖股票的最佳时机Ⅲ</h1>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class P123 {
    //可以将两笔交易分开算，也就是通过第一笔卖出的Index将数组分成两部分，以每一个位置为第一笔交易的卖出位置，将数组两部分分别计算可得的最大利润。
    //可以当天卖掉再买回
    //时间复杂度为O(n^2)超时了，感觉可以用一些高级数据结构优化
    //感觉有点单调队列的味道
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int min1 = prices[0];
            int profit1 = 0;
            for (int j = 0; j <= i; j++) {
                if (prices[j] < min1) {
                    min1 = prices[j];
                } else {
                    profit1 = Math.max(profit1,prices[j] - min1);
                }
            }
            int min2 = prices[i];
            int profit2 = 0;
            for (int j = i; j < n; j++) {
                if (prices[j] < min2) {
                    min2 = prices[j];
                } else {
                    profit2 = Math.max(profit2,prices[j] - min2);
                }
            }
            max = Math.max(max,profit1 + profit2);
        }
        return max;
    }

    public int maxProfitV1(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
