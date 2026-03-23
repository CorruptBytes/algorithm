package com.example.island3;

import java.util.Scanner;

/**
 * <h1>海岸线计算</h1>
 * <p>给定一个由 1（陆地）和 0（水）组成的矩阵，
 * 岛屿是被水包围，并且通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设矩阵外均被水包围。在矩阵中恰好拥有一个岛屿，
 * 假设组成岛屿的陆地边长都为 1，请计算海岸线，即：岛屿的周长。岛屿内部没有水域。</p>
 * <a href="https://kamacoder.com/problempage.php?pid=1178">链接</a>
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.nextInt();
            }
        }
        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    System.out.println(dfs(i,j,graph,delta,visited));
                    return;
                }
            }
        }
    }
    public static int dfs(int i, int j, int[][] graph,int[][] delta,boolean[][] visited) {
        if (visited[i][j]) return 0;
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int nextX = i + delta[k][0];
            int nextY = j + delta[k][1];
            visited[i][j] = true;
            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length || graph[nextX][nextY] == 0) res += 1;
            else {
                res += dfs(nextX,nextY,graph,delta,visited);
            }
        }
        return res;
    }
}
