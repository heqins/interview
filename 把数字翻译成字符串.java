public class 把数字翻译成字符串 {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1
     * 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
     * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();

        char[] array = str.toCharArray();
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            int currentNum = (array[i - 1] - '0') * 10 + (array[i] - '0');

            if (currentNum > 9 && currentNum < 26) {
                if (i > 2) {
                    dp[i] += dp[i - 2];
                }else {
                    dp[i]++;
                }
            }
        }

        return dp[len - 1];
    }
}
