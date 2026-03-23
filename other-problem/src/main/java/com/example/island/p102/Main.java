package com.example.island.p102;

import java.util.Scanner;

/**
 * <h1>沉没孤岛</h1>
 * <p>给定一个由 1（陆地）和 0（水）组成的矩阵，
 * 岛屿指的是由水平或垂直方向上相邻的陆地单元格组成的区域，
 * 且完全被水域单元格包围。孤岛是那些位于矩阵内部、所有单元格都不接触边缘的岛屿。
 * 现在你需要将所有孤岛“沉没”，即将孤岛中的所有陆地单元格（1）转变为水域单元格（0）。</p>
 * <a href="https://kamacoder.com/problempage.php?pid=1174">链接</a>
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] graph = new int[n][m];
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < m) {
                graph[i][j] = s.nextInt();
                j++;
            }
            i++;
            j = 0;
        }
        boolean[][] visited = new boolean[n][m];
        boolean[] flag = new boolean[1];
        flag[0] = true;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j,graph,visited,flag);
                    if (flag[0]) sinking(i,j,graph);
                    flag[0] = true;
                }

            }
        }
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = 0; i2 < m; i2++) {
                System.out.print(graph[i1][i2]);
                if (i2 != m - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int i, int j, int[][] graph, boolean[][] visited, boolean[] flag) {
        int n = graph.length;
        int m = graph[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || graph[i][j] == 0 || visited[i][j]) return;
        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) flag[0] = false;
        visited[i][j] = true;
        dfs(i - 1, j, graph,visited,flag);
        dfs(i + 1, j, graph,visited,flag);
        dfs(i, j - 1, graph,visited,flag);
        dfs(i, j + 1, graph,visited,flag);
    }

    public static void sinking(int i, int j, int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || graph[i][j] == 0) return;
        graph[i][j] = 0;
        sinking(i - 1, j, graph);
        sinking(i + 1, j, graph);
        sinking(i, j - 1, graph);
        sinking(i, j + 1, graph);
    }
}
