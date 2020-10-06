public class 多少种分类硬币币值问题 {
    public int countWays(int n) {
        // write code here
        int[] coins = new int[]{1, 5, 10, 25};

        int[] dp = new int[100001];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = coins[i]; j <= n; j++) {
                // 当前钱数-选择的硬币币值
                // 如果sum=0，那么无论有前多少种来组合0，只有一种可能，就是各个系数都等于0
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
