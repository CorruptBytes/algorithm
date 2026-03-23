package com.example.y2026.m02.day26;

/**
 * <h1>将二进制表示减到1的步骤数</h1>
 * <p>给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。</p>
 * <a href="https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one">链接</a>
 */
public class P1404 {

    public int numSteps(String s) {
        int i = s.length() - 1;
        boolean carry = false;
        int count = 0;
        while (i > 0) {
            char c = s.charAt(i);
            if (c == '1') {
                if (carry) {
                    count += 1;
                } else {
                    carry = true;
                    count += 2;
                }
            } else {
                if (carry) {
                    count += 2;
                } else {
                    count++;
                }
            }
            i--;
        }
        return carry ? count + 1 : count;
    }

}
