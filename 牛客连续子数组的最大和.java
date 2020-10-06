public class 牛客连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        // {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
        int max = array[0];

        int[] dp = new int[array.length];

        dp[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + array[i] : array[i];
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
