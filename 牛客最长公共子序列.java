public class 牛客最长公共子序列 {
    public static String LCS (String s1, String s2) {
        // write code here
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1+1][length2+1];
        char[][] dp2 = new char[length1+1][length2+1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    dp2[i][j] = s1.charAt(i-1);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        int a = length1;
        int b = length2;
        for (int i =dp[length1][length2]; i >0 ; i--) {

            boolean flag  = false;
            for (int j = a; j >=1 ; j--) {
                for (int k = b; k >=1; k--) {
                    if(dp[j][k]==i && dp2[j][k]!=0 ){
                        sb.append(dp2[j][k]);
                        a = j;
                        b = k;
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    break;
                }

            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LCS("1A2C3D4B56", "B1D23CA45B6A");
    }
}
