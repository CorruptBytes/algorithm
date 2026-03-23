package com.example.y2026.m02.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>简化路径</h1>
 * <p>给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 * 在 Unix 风格的文件系统中规则如下：
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * 返回的 简化路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。</p>
 * <a href="https://leetcode.cn/problems/simplify-path">链接</a>
 */
public class P71 {

    public String simplifyPath(String path) {
        int n = path.length();
        List<String> paths = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (path.charAt(i) == '/') {
                while (i < n && path.charAt(i) == '/') {
                    i++;
                }
            }
            int r = i;
            while (r < n && path.charAt(r) != '/') {
                r++;
            }
            String substring = path.substring(i, r);
            switch (substring) {
                case "", "." -> {
                }
                case ".." -> {
                    if (!paths.isEmpty()) paths.removeLast();
                }
                default -> paths.add(substring);
            }
            i = r;
        }
        n = paths.size();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append('/');
            sb.append(paths.get(j));
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
