package com.example.y2026.m05.day10;

import java.util.*;

/**
 * <h1>字符串接龙</h1>
 * <h3>题目描述</h3>
 * <p>字典 strList 中从字符串 beginStr 和 endStr 的转换序列是一个按下述规格形成的序列：
 * 1. 序列中第一个字符串是 beginStr。
 * 2. 序列中最后一个字符串是 endStr。
 * 3. 每次转换只能改变一个字符。
 * 4. 转换过程中的中间字符串必须是字典 strList 中的字符串，且strList里的每个字符串只用使用一次。
 * 给你两个字符串 beginStr 和 endStr 和一个字典 strList，找到从 beginStr 到 endStr 的最短转换序列中的字符串数目。如果不存在这样的转换序列，返回 0。</p>
 * <h3>输入描述</h3>
 * 第一行包含一个整数 N，表示字典 strList 中的字符串数量。 第二行包含两个字符串，用空格隔开，分别代表 beginStr 和 endStr。 后续 N 行，每行一个字符串，代表 strList 中的字符串。
 * <h3>输出描述</h3>
 * 输出一个整数，代表从 beginStr 转换到 endStr 需要的最短转换序列中的字符串数量。如果不存在这样的转换序列，则输出 0。
 */
public class KamaP110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String begin = sc.next();
        String end = sc.next();
        HashSet<String> set = new HashSet<>();
        set.add(begin);
        set.add(end);
        while (n-- > 0) {
            set.add(sc.next());
        }
        HashMap<String,Integer> distance = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        distance.put(begin,1);
        queue.offer(begin);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int length = cur.length();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 26; j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    sb.setCharAt(i,(char)(97 + j));
                    String next = sb.toString();
                    if (set.contains(next) && !distance.containsKey(next)) {
                        distance.put(next,distance.get(cur) + 1);
                        queue.offer(next);
                    }
                    if (end.equals(next)) {
                        System.out.println(distance.get(cur) + 1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

}
