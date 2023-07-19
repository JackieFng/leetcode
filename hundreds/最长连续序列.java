package hundreds;

import java.util.*;

/**
 * @author: jackie
 * @date: 2023/7/19 11:05
 **/
public class 最长连续序列 {

    /**
     * 题目要求时间复杂度为O(n)
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        //去重
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            //每个数若存在前驱数，则表明该数不是最长连续序列的第一个数，应该跳过
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                //找到第一个数遍历set找到所有连续的数
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                //题目要求找到最长的，记录每次遍历找到的最长序列，取较大者
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
