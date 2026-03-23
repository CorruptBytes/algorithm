package com.example.day20;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <h1>滑动窗口最大值</h1>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class P239 {
    //首先尝试暴力循环遍历能不能通过   超出时间限制
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = getMax(nums,i,i + k);
        }
        return result;
    }
    private int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start; i < end; i++) {
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    //使用单调队列，维护一个从大到小的序列
    public int[] maxSlidingWindowV2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        result[0] = queue.getMax();
        for (int i = 1; i < result.length; i++) {
            queue.pop(nums[i - 1]);
            queue.push(nums[i + k - 1]);
            result[i] = queue.getMax();
        }
        return result;
    }
}
class MyQueue {
    private final LinkedList<Integer> list;
    public MyQueue() {
        list = new LinkedList<>();
    }
    public void push(int value) {
        while (!list.isEmpty() && list.getLast() < value) {
            list.removeLast();
        }
        list.addLast(value);
    }
    //根据value弹出元素，如果对头不是value，则不弹出
    public void pop(int value) {
        if (!list.isEmpty() && list.getFirst() == value) {
            list.removeFirst();
        }
    }
    //单调队列的对头元素就是最大值
    public int getMax() {
        return list.getFirst();
    }
}
