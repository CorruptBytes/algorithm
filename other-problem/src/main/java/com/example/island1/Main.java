package com.example.island1;

import java.util.Arrays;
import java.util.Scanner;

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
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    max = Math.max(dfs(i, j, graph, visited),max);
                } else {
                    graph[i][j] = 1;
                    max = Math.max(dfs(i, j, graph, visited),max);
                    graph[i][j] = 0;
                }
                for (int k = 0; k < n; k++) {
                    Arrays.fill(visited[k],false);
                }

            }
        }
        System.out.println(max);
    }

    public static int dfs(int i, int j,int[][] graph,boolean[][] visited) {
        if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || visited[i][j] || graph[i][j] == 0) return 0;
        visited[i][j] = true;
        return 1 + dfs(i - 1,j,graph,visited) + dfs(i + 1,j,graph,visited)
                + dfs(i,j - 1,graph,visited) + dfs(i,j + 1,graph,visited);
    }
}
