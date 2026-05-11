package com.example.y2026.m05.day3;

/**
 * <h1>跳跃游戏Ⅱ</h1>
 * <p>给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 * 0 <= j <= nums[i] 且
 * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。</p>
 *  <a href="https://leetcode.cn/problems/jump-game-ii">链接</a>
 */
public class P45 {

    public int jump(int[] nums) {
        int cover = nums[0];
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1;i++) {
            max = Math.max(max,i + nums[i]);
            if (i == cover) {
                count++;
                cover = max;
            }
            if (cover >= nums.length - 1) {
                count++;
                return count;
            }
        }
        return count;
    }

}
