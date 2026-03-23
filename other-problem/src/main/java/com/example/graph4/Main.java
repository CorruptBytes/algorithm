package com.example.graph4;

import java.util.Scanner;

/**
 * <h1>高山流水</h1>
 * <p>现有一个 N × M 的矩阵，每个单元格包含一个数值，
 * 这个数值代表该位置的相对高度。矩阵的左边界和上边界被认为是第一组边界，
 * 而矩阵的右边界和下边界被视为第二组边界。
 * 矩阵模拟了一个地形，当雨水落在上面时，
 * 水会根据地形的倾斜向低处流动，但只能从较高或等高的地点流向较低或等高并且相邻（上下左右方向）的地点。
 * 我们的目标是确定那些单元格，从这些单元格出发的水可以达到第一组边界和第二组边界。</p>
 */
public class Main {
    /**
     * 遍历每一个节点，向边界找一条递减路径，如果存在，就说明是目标节点。
     * @param args
     */
    /**
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
        List<int[]> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        boolean[] up = new boolean[1];
        boolean[] down = new boolean[1];
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                dfs(i,j,graph,graph[i][j],up,down,visited);
                if (up[0] && down[0]) res.add(new int[]{i,j});
                up[0] = false;
                down[0] = false;
                for (int i1 = 0; i1 < n; i1++) {
                    Arrays.fill(visited[i1],false);
                }
            }
        }
        for (int[] node : res) {
            System.out.println(node[0] + " " + node[1]);
        }

    }

    public static void dfs(int i, int j,int[][] graph,int path,boolean[] up,boolean[] down,boolean[][] visited) {
        int n = graph.length;
        int m = graph[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || graph[i][j] > path) return;
        if (i == 0 || j == 0) {
            up[0] = true;
        }
        if (i == n - 1 || j == m - 1) {
            down[0] = true;
        }
        visited[i][j] = true;
        dfs(i - 1,j,graph,graph[i][j],up,down,visited);
        dfs(i + 1,j,graph,graph[i][j],up,down,visited);
        dfs(i,j - 1,graph,graph[i][j],up,down,visited);
        dfs(i,j + 1,graph,graph[i][j],up,down,visited);
        visited[i][j] = false;
    }
     **/
    /**
     * 更合理的思路：
     * 从第一组边界出发，只走高度 >= 当前点 的格子，标记所有能到达的格子
     *再对 第二组边界 做同样的事情。最后取交集。
     */
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
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

        boolean[][] upVisited = new boolean[n][m];
        boolean[][] downVisited = new boolean[n][m];

        // 第一组边界（上 + 左）
        for (int i = 0; i < n; i++) {
            dfs(i,0,graph,upVisited);
        }
        for (int j = 0; j < m; j++) {
            dfs(0,j,graph,upVisited);
        }

        // 第二组边界（下 + 右）
        for (int i = 0; i < n; i++) {
            dfs(i,m-1,graph,downVisited);
        }
        for (int j = 0; j < m; j++) {
            dfs(n-1,j,graph,downVisited);
        }

        // 输出交集
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (upVisited[i][j] && downVisited[i][j]) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    static void dfs(int i,int j,int[][] graph,boolean[][] visited){
        int n = graph.length;
        int m = graph[0].length;
        visited[i][j] = true;
        for (int[] d : dirs){
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni>=0 && ni<n && nj>=0 && nj<m && !visited[ni][nj] && graph[ni][nj] >= graph[i][j]) {
                dfs(ni,nj,graph,visited);
            }
        }
    }
}
