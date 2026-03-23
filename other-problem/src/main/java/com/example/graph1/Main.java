package com.example.graph1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * <h1>计数孤岛</h1>
 * <p>给定一个由 1（陆地）和 0（水）组成的矩阵，你需要计算岛屿的数量。
 * 岛屿由水平方向或垂直方向上相邻的陆地连接而成，并且四周都是水域。你可以假设矩阵外均被水包围。</p>
 * <a href="https://kamacoder.com/problempage.php?pid=1171">链接</a>
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
                if (graph[i][j] == 0) continue;
                res++;
                bfs(i,j,graph);
            }
        }
        System.out.println(res);
    }
    //深度优先搜索版本
    public static void dfs(int i, int j, int[][] graph) {
        if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || graph[i][j] == 0) return;
        graph[i][j] = 0;
        dfs(i + 1,j,graph);
        dfs(i - 1,j,graph);
        dfs(i,j + 1,graph);
        dfs(i,j - 1,graph);
    }

    //广度优先搜索版本
    public static void bfs(int i, int j, int[][] graph) {
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node(i,j));
        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!list.isEmpty()) {
            Node node = list.pop();
            int x = node.x;
            int y = node.y;
            for (int k = 0; k < 4; k++) {
                int nextX = x + delta[k][0];
                int nextY = y + delta[k][1];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length || graph[nextX][nextY] == 0) continue;
                else {
                    list.add(new Node(nextX,nextY));
                    graph[nextX][nextY] = 0;
                }
            }

        }
    }
    private static class Node {
        int x;
        int y;
        public Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
