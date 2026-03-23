package com.example.y2026.m01.day15;

import java.lang.reflect.Parameter;

/**
 * <h1>比较版本号</h1>
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。
 * 版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 */
public class P165 {
    int i1 = 0;
    int i2 = 0;
    public int compareVersion(String version1, String version2) {
        int l1 = version1.length();
        int l2 = version2.length();
        while (i1 < l1 || i2 < l2) {
            int num1 = parse1(version1);
            int num2 = parse2(version2);
            if (num1 > num2) return 1;
            if (num2 > num1) return -1;
        }
        return 0;
    }

    private int parse1(String version) {
        if (i1 == version.length()) return 0;
        int result = 0;
        while (i1 < version.length()) {
            char c = version.charAt(i1++);
            if (c == '.') return result;
            result = result * 10 + (c - '0');
        }
        return result;
    }
    private int parse2(String version) {
        if (i2 == version.length()) return 0;
        int result = 0;
        while (i2 < version.length()) {
            char c = version.charAt(i2++);
            if (c == '.') return result;
            result = result * 10 + (c - '0');
        }
        return result;

    }

    public static void main(String[] args) {
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        P165 test = new P165();
        System.out.println(test.compareVersion(version1,version2));

    }

}
