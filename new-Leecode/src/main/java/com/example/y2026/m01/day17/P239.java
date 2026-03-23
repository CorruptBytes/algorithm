package com.example.y2026.m01.day17;

import java.util.LinkedList;

/**
 * <h1>滑动窗口最大值</h1>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class P239 {
    //单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MyQueue queue = new MyQueue();
        //初始化单调队列
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        result[0] = queue.getFirst();
        int len = result.length;

        for (int i = 1; i < result.length; i++) {
            queue.remove(nums[i - 1]);
            queue.push(nums[i + k - 1]);
            result[i] = queue.getFirst();
        }
        return result;
    }
    private static class MyQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        public int getFirst() {
            return queue.getFirst();
        }
        public void push(int num) {
            while (!queue.isEmpty() && queue.peekLast() < num) {
                queue.removeLast();
            }
            queue.addLast(num);
        }
        //根据value弹出元素，如果对头不是value，则不弹出
        public void remove(int num) {
            if (!queue.isEmpty() && queue.peek() == num) {
                queue.removeFirst();
            }
        }
    }
}
