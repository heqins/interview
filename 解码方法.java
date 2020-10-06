public class 解码方法 {
    public static int numDecodings(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();

        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n; i++){
            if (cs[i] != '0') dp[i] += dp[i - 1];
            // 分为能和前一个字符组在一块，不能组在一块
            if (cs[i - 1] == '1' || (cs[i - 1] == '2' && cs[i] <= '6')) {
                if (i > 1) {
                    dp[i] += dp[i - 2];
                }else {
                    dp[i]++;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("223"));
    }
}
