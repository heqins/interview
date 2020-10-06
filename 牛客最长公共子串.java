public class 牛客最长公共子串 {
    public static String LCS (String str1, String str2) {
        // write code here
        if (str1 == null || str2 == null) return "-1";

        int max = Integer.MIN_VALUE;

        int index = 0;
        int m = str1.length(), n = str2.length();

        int[][] dp = new int[m][n];

        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index = i;
                }
            }
        }

        if (max == 0) return "-1";

        return str1.substring(index - max + 1, index + 1);
    }

    public static void main(String[] args) {
        LCS("1AB2345CD", "12345EF");
    }
}
