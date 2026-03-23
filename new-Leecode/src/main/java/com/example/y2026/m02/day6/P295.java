package com.example.y2026.m02.day6;

import java.util.PriorityQueue;

/**
 * <h1>数据流中的中位数</h1>
 * <p> 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。</p>
 */
public class P295 {
}
class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>((a,b) -> b - a); //存储小于等于中位数的数
        max = new PriorityQueue<>((a,b) -> a - b);//存储大于中位数的数
    }

    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            if (max.size() + 1 < min.size()) {
                max.offer(min.poll());
            }
        } else {
            max.offer(num);
            if (max.size() > min.size()) {
                min.offer(max.poll());
            }
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return min.peek();
        }
    }
}