package com.example.day54;

import java.util.PriorityQueue;

/**
 * <h1>数据流中的中位数</h1>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */
public class P295 {

}

class MedianFinder {
    PriorityQueue<Integer> min ; //存小于中位数的数
    PriorityQueue<Integer> max ; //存大于中位数的数
    public MedianFinder() {
        min = new PriorityQueue<Integer>((a, b) -> (b - a));
        max = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        min.add(num);
        max.add(min.poll());
        if (max.size() > min.size())
            min.add(max.poll());
    }

    public double findMedian() {
        if (max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        else
            return min.peek();
    }

}
class MedianFinderV2 {
    //Java的优先队列默认是小顶堆，即最小的元素在队头
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinderV2() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a)); //存小于中位数的数
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b)); //存大于中位数的数
    }
    //通过维护两个优先队列的元素数量来维护中位数始终在两个队列的队头。
    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}
