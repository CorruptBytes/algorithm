package com.example.y2026.m02.day15;

/**
 * <h1>颠倒二进制位</h1>
 * <p>颠倒给定的 32 位有符号整数的二进制位。</p>
 * <a href="https://leetcode.cn/problems/reverse-bits">链接</a>
 *
 */
public class P190 {

    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            sb.append(n & 1);
            n >>= 1;
        }
        while (sb.length() < 32) {
            sb.append('0');
        }
        return Integer.parseInt(sb.toString(),2);
    }

    public int reverseBitsV1(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }


}
