package com.example.y2026.m02.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>文本左右对齐</h1>
 * <p>给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。</p>
 * <a href="https://leetcode.cn/problems/text-justification/description>链接</a>
 */
public class P68 {
    //无敌了，面向用例编程
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int len = 0;
            int start = i;
            while (i < n && len <= maxWidth) {
                len += words[i++].length() + 1;
                if (len - 1 == maxWidth) {
                    len -= 1;
                    break;
                }
            }
            if (len > maxWidth) {
                i--;
                len -= words[i].length() + 2;
            }
            int count = i - start;
            if (count == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(words[start]).repeat(' ',maxWidth - sb.length());
                res.add(sb.toString());
                continue;
            }
            if (i == n) {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j < n; j++) {
                    sb.append(words[j]);
                    if (j != n - 1) sb.append(' ');
                }
                if (sb.length() < maxWidth) sb.repeat(' ',maxWidth -sb.length());
                res.add(sb.toString());
                continue;
            }
            int space = maxWidth - len;
            int interval = count - 1;
            int single = space / interval;
            int remaining = space - single * interval;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count; j++) {
                sb.append(words[start + j]);
                if (j != count - 1) {
                    sb.append(' ');
                    sb.repeat(' ',single + ((remaining-- > 0) ? 1 : 0));
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        int len = 3;
        len -= 3 + 2;
        System.out.println(len);
    }
}
