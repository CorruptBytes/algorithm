package com.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * <h1>所有可达路径</h1>
 * <p>给定一个有 n 个节点的有向无环图，节点编号从 1 到 n。
 * 请编写一个程序，找出并返回所有从节点 1 到节点 n 的路径。每条路径应以节点编号的列表形式表示。
 * 输入描述
 * 第一行包含两个整数 N，M，表示图中拥有 N 个节点，M 条边
 * 后续 M 行，每行包含两个整数 s 和 t，表示图中的 s 节点与 t 节点中有一条路径
 * 输出描述
 * 输出所有的可达路径，路径中所有节点之间空格隔开，每条路径独占一行，存在多条路径，路径输出的顺序可任意。
 * 如果不存在任何一条路径，则输出 -1。
 * 注意输出的序列中，最后一个节点后面没有空格！ 例如正确的答案是 `1 3 5`,而不是 `1 3 5 `， 5后面没有空格！
 * </p>
 * <a href="https://kamacoder.com/problempage.php?pid=1170">链接</a>
 */
public class Main {
    /**
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        while (m-- > 0) {
            graph.get(s.nextInt() - 1).add(s.nextInt());
        }
        List<Integer> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        path.add(1);
        dfs(1,n,path,graph,res);
        if (res.isEmpty()) System.out.println(-1);
        else {
            res.forEach(System.out::println);
        }
    }


    public static void dfs(int node,int n,List<Integer> path,List<List<Integer>> graph,List<String> res) {
        if (node == n) {
            StringJoiner sj = new StringJoiner(" ");
            path.forEach((s) -> sj.add(s.toString()));
            res.add(sj.toString());
            return;
        }
        for (Integer nextNode : graph.get(node - 1)) {
            if (path.contains(nextNode)) {
                continue;
            }
            path.add(nextNode);
            dfs(nextNode,n,path,graph,res);
            path.removeLast();
        }
    }
     **/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        while (m-- > 0) {
            graph[s.nextInt()][s.nextInt()] = 1;
        }
        List<Integer> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        path.add(1);
        dfs(1,n,path,graph,res);
        if (res.isEmpty()) System.out.println(-1);
        else {
            res.forEach(System.out::println);
        }
    }

    public static void dfs(int node,int n,List<Integer> path,int[][] graph,List<String> res) {
        if (node == n) {
            StringJoiner sj = new StringJoiner(" ");
            path.forEach((s) -> sj.add(s.toString()));
            res.add(sj.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 0 || path.contains(i)) continue;
            path.add(i);
            dfs(i,n,path,graph,res);
            path.remove(path.size() - 1);
        }
    }
}
