package com.example.y2026.m01.day29;

import java.util.*;

/**
 * <h1>课程表</h1>
 * <p>你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。</p>
 * <a href="https://leetcode.cn/problems/course-schedule">链接</a>
 */
public class P207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度数组，用于记录每门课程的入度
        int[] inDegree = new int[numCourses];
        // 邻接表，存储每门课程的后续课程
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // 计算每门课程的入度，并构建邻接表
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            inDegree[course]++;
            adjList.get(preCourse).add(course);
        }

        // 存储入度为 0 的课程的队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 记录已完成课程的数量
        int count = 0;
        while (!queue.isEmpty()) {
            int selectedCourse = queue.poll();
            count++;
            // 获取当前课程的后续课程列表
            List<Integer> nextCourses = adjList.get(selectedCourse);
            for (int nextCourse : nextCourses) {
                // 后续课程的入度减 1
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 如果已完成课程的数量等于总课程数，则可以完成所有课程
        return count == numCourses;
    }
}
