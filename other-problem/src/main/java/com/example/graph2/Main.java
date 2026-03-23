package com.example.graph2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * <h1>最大岛屿的面积</h1>
 * <p>给定一个由 1（陆地）和 0（水）组成的矩阵，计算岛屿的最大面积。岛屿面积的计算方式为组成岛屿的陆地的总数。
 * 岛屿由水平方向或垂直方向上相邻的陆地连接而成，并且四周都是水域。你可以假设矩阵外均被水包围。</p>
 * <a href="https://kamacoder.com/problempage.php?pid=1172">链接</a>
 */

/**
 * 广度优先搜索
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
        int res = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    res = Math.max(bfs(i,j,graph),res);
                }
            }
        }
        System.out.println(res);
    }
    public static int bfs(int i, int j, int[][] graph) {
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{i,j});
        int count = 0;
        graph[i][j] = 0;
        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!list.isEmpty()) {
            int[] node = list.pop();
            int x = node[0];
            int y = node[1];
            count++;
            for (int k = 0; k < 4; k++) {
                int nextX = x + delta[k][0];
                int nextY = y + delta[k][1];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length || graph[nextX][nextY] == 0) continue;
                else {
                    graph[nextX][nextY] = 0;
                    list.add(new int[]{nextX,nextY});
                }
            }
        }
        return count;
    }
}

class Main1 {
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
        int res = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    res = Math.max(bfs(i,j,graph),res);
                }
            }
        }
        System.out.println(res);
    }
    public static int bfs(int i, int j, int[][] graph) {
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{i,j});
        int count = 0;
        graph[i][j] = 0;
        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!list.isEmpty()) {
            int[] node = list.pop();
            int x = node[0];
            int y = node[1];
            count++;
            for (int k = 0; k < 4; k++) {
                int nextX = x + delta[k][0];
                int nextY = y + delta[k][1];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length || graph[nextX][nextY] == 0) continue;
                else {
                    graph[nextX][nextY] = 0;
                    list.add(new int[]{nextX,nextY});
                }
            }
        }
        return count;
    }
}
