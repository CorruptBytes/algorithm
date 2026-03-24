package com.example.y2026.m03.day24;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。

假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。
一次基因变化就意味着这个基因序列中的一个字符发生了变化。

例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
（变化后的基因必须位于基因库 bank 中）

给你两个基因序列 start 和 end ，以及一个基因库 bank ，
请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。

注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
<a href="https://leetcode.cn/problems/minimum-genetic-mutation">链接</a>
 */

public class P433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
            Set<String> cnt = new HashSet<>();
            Set<String> visited = new HashSet<>();
            for (String gene : bank) {
                cnt.add(gene);
            }
            if (startGene.equals(endGene)) {
                return 0;
            }
            if (!cnt.contains(endGene)) {
                return -1;
            }
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(startGene);
            visited.add(startGene);
            char[] keys = {'A','C','G','T'};
            int step = 1;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for(int k = 0; k < sz; k++){
                    for ( int i = 0; i < 8; i++) {
                        String gene = queue.poll();
                        for (int j = 0; j < 4; j++) {
                            if (keys[j] == gene.charAt(i)) {
                                continue;
                            }
                            StringBuilder sb = new StringBuilder(gene);
                            sb.setCharAt(i,keys[j]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(endGene)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
    }
}


