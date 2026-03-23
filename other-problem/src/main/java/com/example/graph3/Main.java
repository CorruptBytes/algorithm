package com.example.graph3;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * <h1>孤岛的总面积</h1>
 * <p>给定一个由 1（陆地）和 0（水）组成的矩阵，
 * 岛屿指的是由水平或垂直方向上相邻的陆地单元格组成的区域，
 * 且完全被陆地单元格包围。孤岛是那些位于矩阵内部、所有单元格都不接触边缘的岛屿。
 * 现在你需要计算所有孤岛的总面积，岛屿面积的计算方式为组成岛屿的陆地的总数。</p>
 * <a href="https://kamacoder.com/problempage.php?pid=1173">链接</a>
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
                    res += bfs(i, j, graph);
                }
            }
        }
        System.out.println(res);
    }
    public static int bfs(int i, int j,int[][] graph) {
        LinkedList<int[]> list = new LinkedList<>();
        int n = graph.length;
        int m = graph[0].length;
        list.add(new int[]{i,j});
        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
        graph[i][j] = 0;
        boolean flag = false;
        while (!list.isEmpty()) {
            int[] node = list.poll();
            int x = node[0];
            int y = node[1];
            count++;
            if (x == 0 || x == n - 1 || y == 0 || y == m - 1) flag = true;
            for (int k = 0; k < 4; k++) {
                int nextX = x + delta[k][0];
                int nextY = y + delta[k][1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || graph[nextX][nextY] == 0) {
                  continue;
                }
                graph[nextX][nextY] = 0;
                list.offer(new int[]{nextX,nextY});
            }
        }
        return flag ? 0 : count;
    }
}
