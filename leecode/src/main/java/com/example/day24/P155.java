package com.example.day24;

import java.util.Stack;

public class P155 {
    //使用辅助栈，主栈中存储放入的元素，辅助栈中维护最小元素。
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;
        public MinStack() {
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
}
