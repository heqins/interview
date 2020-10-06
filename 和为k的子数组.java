import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        // 前缀和, 记录前缀和出现的次数
        /**
         * 前缀和不难，却很有用，主要用于处理数组区间的问题。
         *
         * 比如说，让你统计班上同学考试成绩在不同分数段的百分比，也可以利用前缀和技巧：
         *
         * int[] scores; // 存储着所有同学的分数
         * // 试卷满分 150 分
         * int[] count = new int[150 + 1]
         * // 记录每个分数有几个同学
         * for (int score : scores)
         *     count[score]++
         * // 构造前缀和
         * for (int i = 1; i < count.length; i++)
         *     count[i] = count[i] + count[i-1];
         *
         *这样，给你任何一个分数段，你都能通过前缀和相减快速计算出这个分数段的人数，百分比也就很容易计算了。
         */

        // 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
        Map<Integer, Integer> map = new HashMap<>();

        int pre = 0;

        map.put(0, 1);

        int res = 0;

        for (int num: nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return res;
    }
}
