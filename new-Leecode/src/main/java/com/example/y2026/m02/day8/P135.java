package com.example.y2026.m02.day8;

import java.util.Arrays;

/**
 * <h1>分发糖果</h1>
 * <p>n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。</p>
 * <a href="https://leetcode.cn/problems/candy/description">链接</a>
 */
public class P135 {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int count = 1;
        int result = candies[candies.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            result += Math.max(candies[i],count);
        }

        return result;
    }

}

class Solution {
    public int candy(int[] ratings) {
        // 特殊情况：0 或 1 个孩子，直接返回人数
        if (ratings.length <= 1) return ratings.length;

        int up = 0;        // 当前连续“上坡”的长度（递增段长度）
        int down = 0;      // 当前连续“下坡”的长度（递减段长度）
        int oldSlope = 0;  // 上一个坡度：>0 上坡，<0 下坡，=0 平地
        int result = 0;    // 累计糖果数（已结算完成的“山”和“平地”）

        // 从第二个孩子开始，看相对前一个的变化趋势
        for (int i = 1; i < ratings.length; i++) {

            // 计算当前坡度：
            //  1  -> ratings[i] > ratings[i - 1]（上坡）
            // -1  -> ratings[i] < ratings[i - 1]（下坡）
            //  0  -> ratings[i] == ratings[i - 1]（平地）
            int newSlope = Integer.compare(ratings[i], ratings[i - 1]);

            /*
             * 如果满足以下任一条件，说明“一整座山”走完了：
             *
             * 1️⃣ 之前是上坡，现在变成平地
             *    ↑ ↑ ↑  →
             *
             * 2️⃣ 之前是下坡，现在变成平地或上坡
             *    ↓ ↓ ↓  → 或 ↑
             *
             * 此时可以安全结算：
             *   左坡 + 右坡 + 峰值修正
             */
            if ((oldSlope > 0 && newSlope == 0) ||
                    (oldSlope < 0 && newSlope >= 0)) {

                // 左边递增段贡献：1 + 2 + ... + up
                result += up * (up + 1) / 2;

                // 右边递减段贡献：1 + 2 + ... + down
                result += down * (down + 1) / 2;

                // 峰值只算一次，取左右坡中更大的那个
                result += Math.max(up, down);

                // 清空，开始记录下一座山
                up = down = 0;
            }

            // 根据当前坡度，更新上坡 / 下坡长度
            if (newSlope > 0) {
                // 上坡：递增段继续延长
                up++;
            } else if (newSlope < 0) {
                // 下坡：递减段继续延长
                down++;
            } else {
                // 平地：这个孩子至少 1 颗糖，直接结算
                result++;
            }

            // 更新坡度状态，留给下一轮判断
            oldSlope = newSlope;
        }

        /*
         * for 循环结束后，最后一座“山”还没结算
         * 统一在这里补上
         */
        result += up * (up + 1) / 2;        // 左坡
        result += down * (down + 1) / 2;    // 右坡
        result += Math.max(up, down) + 1;   // 峰值 + 最右端那个孩子

        return result;
    }

}
