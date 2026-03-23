package com.example.y2026.m02.day15;

/**
 * <h1>数字范围按位与</h1>
 * <p>给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。</p>
 * <a href="https://leetcode.cn/problems/bitwise-and-of-numbers-range">链接</a>
 */
public class P201 {
    //只看第一个二进制位，只存在0,1两种情况，所以如果left<right，
    // 区间中必然存在left+1,那么最低位&一下一定等于0了，然后不停的右移，一直移到两个相等为止
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
