package com.example.day31;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * <h1>最大数</h1>
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class P179 {
    //贪心算法，如果
    public String largestNumber(int[] nums) {
        String[] integers = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(integers,(a,b) -> {
            String sa = a + b;String sb = b + a;
            return sb.compareTo(sa);
        });
        StringBuilder sb = new StringBuilder();
        for (String integer : integers) {
            sb.append(integer);
        }
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') {
            k++;
        }
        return sb.substring(k);
    }
}
