package com.example.y2026.m04.day9;

public class P909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        dfs(board, 1, visited, 1,false);
        return max;
    }
    int max = -1;
    public void dfs(int[][] board,int num, boolean[][] visited,int count,boolean jump) {
        int n = board.length;
        if (num > n * n) {
            return;
        }
        if (num == n * n) {
            max = Math.min(count, max);
            return;
        }
        int[] index = toIndex(num, n);
        int r = index[0];
        int c = index[1];
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        if (board[r][c] != -1 && !jump) {
            dfs(board, board[r][c], visited, count + 1,true);
        }
        for(int i = 1; i <7; i++) {
            dfs(board, num + i, visited, count + 1,false);
        }
        visited[r][c] = false;
    }
    public int toNum(int i, int j,int n) {
        int start = (n - 1 - i) * n;
        if (i % 2 == 0) {
            return start + j + 1;
        } else {
            return start + (n - j);
        }
    }
    public int[] toIndex(int num,int n) {
        int row = n - (num / n) - 1;

        int column = (n - row - 1) % 2 == 0 ? num % n - 1:  n - (num % n);
        return new int[] {row,column};
    }
}
