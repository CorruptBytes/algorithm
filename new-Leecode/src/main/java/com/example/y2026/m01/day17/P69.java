package com.example.y2026.m01.day17;

/**
 * <h1>x的平凡根</h1>
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */

public class P69 {
    //遍历，效率低
    public int mySqrt(int x) {
        for (int i = 0; i <= x; i++) {
            if (i * i - x > 0) return i - 1;
            else if (i * i - x == 0) return i;
            else continue;
        }
        return -1;
    }
    //可以模仿二分查找的思想
    public int mySqrtV1(int x) {
        int l = 0, r = x,result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //因为平方根一定小于等于x，所以只需要在小于等于时更新result
            if ((long) mid * mid <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

}
