package com.example.day22;

import java.util.Collections;
import java.util.Map;

/**
 * <h1>字符串转换整数(atoi)</h1>
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * 函数 myAtoi(string s) 的算法如下：
 * 空格：读入字符串并丢弃无用的前导空格（" "）
 * 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
 * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
 * 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。
 * 具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
 */
public class P8 {
    public int myAtoi(String s) {
        int len = s.length();
        int index = 0;
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        int signal = 1;
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) =='-') {
            signal = -1;
            index++;
        }
        int result = 0;
        for (;index < len;index++) {
            if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                break;
            }
            if (signal == 1 && (result > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE - result * 10 < s.charAt(index) - '0')) {
                return Integer.MAX_VALUE;
            }
            if (signal == -1 && (result < Integer.MIN_VALUE / 10 || Integer.MIN_VALUE - result * 10 >-(s.charAt(index) - '0'))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + signal * (s.charAt(index) - '0');
        }
        return result;
    }
}
