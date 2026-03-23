package com.example.day37;

/**
 * <h1>每日温度</h1>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class P739 {
    //感觉有点动态规划的味道，先用暴力看看
//    public int[] dailyTemperatures(int[] temperatures) {
//        int n = temperatures.length;
//        int[] answer = new int[n];
//        for (int i = 0; i < n; i++) {
//            int j;
//            for (j = i + 1; j < n; j++) {
//               if (temperatures[j] > temperatures[i]) {
//                   break;
//               }
//            }
//            answer[i] = j != n ? j - i : 0;
//        }
//        return answer;
//    }
    //类似动态规划的思想，从后向前遍历，
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        answer[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int j;
            for (j = i + 1; j < n; j+=answer[j]) {
               if (temperatures[j] > temperatures[i]) {
                   //如果temperatures[j] > temperatures[i],则表明找到答案，返回即可
                   answer[i] = j - i;
                   break;
               } else {
                   //如果temperatures[j] <= temperatures[i],则说明不符合，由于是从后往前遍历，此时answer[j]已经有值
                   //如果answer为0,则表示后边的元素均<=temperatures[j],因此小于temperatures[i]，直接返回
                   //如果不为0，则说明[j,j + answer[j])之间的元素均小于temperatures[i],跳过即可.
                   if (answer[j] == 0) {
                       answer[i] = 0;
                       break;
                   }
               }
            }
        }
        return answer;
    }
}
