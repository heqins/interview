public class 牛客最长回文子串 {
    int max = Integer.MIN_VALUE;

    public int getLongestPalindrome(String A, int n) {
        // write code here
        // 第 i 个字符到第 j 个字符是否是回文串
//        boolean[][] dp = new boolean[n][n];
//        int max = 0;
//        // 字符串首尾字母长度差 (d = j-i)
//        for (int d = 0; d < n; d++) {
//            // 字符串起始位置 i
//            for (int i = 0; i < n-d; i++) {
//                // 字符串结束位置 j
//                int j = i+d;
//                // 如果字符串 i 到 j 的首尾相等，再根据字符串 i-1 到 j-1 来确定，即得到递推公式
//                if(A.charAt(i) == A.charAt(j)) {
//                    if(d == 0 || d == 1) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                    if(dp[i][j]) {
//                        // 更新最大长度
//                        max = Math.max(max, d+1);
//                    }
//                }
//            }
//        }


//        return max;

        if (A.length() < 2) return A.length();

        for (int i = 0; i < A.length(); i++) {
            helper(A, i, i);
            helper(A, i, i + 1);
        }

        return max;
    }

    public void helper(String A, int i, int j) {
        while (i >= 0 && j < A.length() && A.charAt(i) == A.charAt(j)) {
            i--;
            j++;
        }

        if (j - i - 1 > max) {
            max = j - i - 1;
        }
    }
}
