package com.example.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>根据身高重建队列</h1>
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。
 * 返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class P406 {

    public int[][] reconstructQueue(int[][] people) {
        List<int[]> queue = new ArrayList<>(people.length);
        Arrays.sort(people,((o1, o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
        }));
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[0][2]);
    }

}
