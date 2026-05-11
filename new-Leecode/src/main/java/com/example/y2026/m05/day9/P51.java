package com.example.y2026.m05.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>N皇后</h1>
 * <p>按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。</p>
 * <a href="https://leetcode.cn/problems/n-queens">链接</a>
 */
public class P51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //初始化棋盘
        List<StringBuilder> square = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            square.add(sb);
        }
        //用于判断哪一列还没有棋子
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();

        backtracking(square,n,columns,diagonals1,diagonals2,res,0);
        return res;
    }
    public void backtracking(List<StringBuilder> square,int n, Set<Integer> columns,Set<Integer> diagonals1,Set<Integer> diagonals2,List<List<String>> res,int i) {
        if (i == n) {
            res.add(square.stream().map(StringBuilder::toString).toList());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (columns.contains(i) || diagonals1.contains(i + j) || diagonals2.contains(i - j)) {
                continue;
            }
            square.get(i).setCharAt(j,'Q');
            columns.add(i);
            diagonals1.add(i + j);
            diagonals2.add(i - j);
            backtracking(square,n,columns,diagonals1,diagonals2,res,i + 1);
            square.get(i).setCharAt(j,'.');
            columns.remove(i);
            diagonals1.remove(i + j);
            diagonals2.remove(i - j);

        }
    }
    public boolean isValid(List<StringBuilder> square,int r,int c,int n) {
        for (int i = r + 1, j = c + 1; i < n && j < n; i++,j++) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--,j--) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = r + 1, j = c - 1; i < n && j >= 0; i++,j--) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--,j++) {
            if (square.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
