package com.example.y2026.m01.day30;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>移掉K位数字</h1>
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，
 * 移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class P402_Repeat {

    /**
     * 对于两个相同长度的数字序列，最左边不同的数字决定了这两个数字的大小，例如，对于 A=1axxx，B=1bxxx，如果 a>b 则 A>B。
     * 若要使得剩下的数字最小，需要保证靠前的数字尽可能小。
     *要求最后得到的数字最小，即每次需要删除从左到右遍历满足非递减序列的最后一个数。
     * 使用单调栈维护非递减序列。
     *
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.isEmpty() ? "0" : ret.toString();
    }
}
