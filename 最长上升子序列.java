import java.util.Arrays;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        // 给定一个无序的整数数组，找到其中最长上升子序列的长度
        //  [10,9,2,5,3,7,101,18]，最长的上升子序列是 [2,3,7,101]，它的长度是 4
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }

                maxLen = Math.max(dp[i], maxLen);
            }
        }

        return maxLen;
    }
}
