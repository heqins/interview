public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 分为两种情况： dp[i - 1] < 0 说明对当前子数组是副作用
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
