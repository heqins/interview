public class 牛客子数组最大乘积 {
    public double maxProduct(double[] arr) {
        double[][] dp = new double[arr.length][2];

        dp[0][0] = arr[0];
        dp[0][1] = arr[0];

        double res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= 0) {
                dp[i][0] = Math.max(arr[i], dp[i - 1][0] * arr[i]);
                dp[i][1] = Math.min(arr[i], dp[i - 1][1] * arr[i]);
            }else {
                dp[i][0] = Math.max(arr[i], dp[i - 1][1] * arr[i]);
                dp[i][1] = Math.min(arr[i], dp[i - 1][0] * arr[i]);
            }

            res = Math.max(res, dp[i][0]);
        }

        return res;
    }
}
