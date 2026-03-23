package com.example.day11;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class P121 {
    //贪心算法，找出每一时刻股票的最低点，计算他之后每天卖出去的利益求最大值。
    public int maxProfit(int[] prices) {
        int max = 0;
        int price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < price) {
                price = prices[i];
            } else {
                max = Math.max(max,prices[i] - price);
            }
        }
        return max;
    }

}
