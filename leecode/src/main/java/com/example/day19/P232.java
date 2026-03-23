package com.example.day19;

import java.util.Stack;

/**
 * <h1>用栈实现队列</h1>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 */
public class P232 {
    static class MyQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }
    }
}
