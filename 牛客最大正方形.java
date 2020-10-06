public class 牛客最大正方形 {
    public int solve (char[][] matrix) {
        // write code here
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') dp[0][i] = 1;
        }
        int res = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res*res;
    }
}
