package com.example.y2026.m01.day20;

import java.util.Stack;

/**
 * <h1>最小栈</h1>
 * <p>设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。</p>
 * <a href="https://leetcode.cn/problems/min-stack">链接</a>
 */
public class P155 {

}

class MinStack {
    Stack<Entry> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Entry(val,val));
            return;
        }
        int min = stack.peek().min;
        if (min < val) stack.push(new Entry(val,min));
        else stack.push(new Entry(val,val));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
class Entry {
    public int val;
    public int min;

    public Entry(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

//使用辅助栈，主栈中存储放入的元素，辅助栈中维护最小元素。
class MinStackV1 {
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStackV1() {
        stack = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min.push(Math.min(min.peek(),val));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
