import java.util.HashMap;
import java.util.Map;

public class 最长的斐波那契子序列的长度 {
    public int lenLongestFibSubseq(int[] A) {
        //套用子序列模板；进行变形；
        int n=A.length;
        int[][] dp=new int[n][n];
        Map<Integer,Integer> map=new HashMap<>();//常规的dp会超时（三重循环），利用map来优化成（两重循环），即有一些循环没必要进行的通过map来优化；
        //base case;
        for(int i=0;i<n;i++){
            map.put(A[i],i);//存的是下标值；
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                dp[i][j]=2;//相当于是说，我dpij这个状态下 不管存不存在斐波那契子序列，这个序列里都至少有两个了；
            }
        }
        //dp;
        /* 三重常规没优化的DP（超时模板）；
        for(int i=1;i<n;i++){
            for(int j=j+1;j<n;j++){
                for(int k=i-1;k>=0;k--){

                }
            }
        }*/
        //int res=Integer.MIN_VALUE;//细节注意，可以是0的；

        /**
         * dp[i][j] 表示以 A[i],A[j]结尾的序列长度
         * 初始化所有可能的dp[i][j] = 2, i < j
         * 预先将A的数值和 idx 插入哈希map，方便后面查找
         * 对于 i, j 结尾的序列，其前一位数应该是 A[j]-A[i]，查找其是否存在与哈希表中
         * 如果存在，且其 idx < idx_i ，可以把前面的A[idx],A[i]结尾的序列跟 A[j]组成更长的序列，则 dp[i][j] = max(dp[i][j],dp[idx][i]+1)
         */

        int res=0;
        for(int i=0;i<n;i++){//本题可以这样做的一个很重要的条件是，题目说A数组是严格单调递增的；
            for(int j=i+1;j<n;j++){
                //if(map.containsKey(j-i)){//找X_i；//细节注意；
                if(map.containsKey(A[j]-A[i])){//找X_i；//细节注意；
                    //if(map.get(j-i)<i){//细节注意；
                    if(map.get(A[j]-A[i])<i){//细节注意；
                        //dp[i][j]=Math.max(dp[i][j],dp[map.get(j-i)][j]+1);
                        dp[i][j]=Math.max(dp[i][j],dp[map.get(A[j]-A[i])][i]+1);
                        res=Math.max(res,dp[i][j]);
                    }
                }
            }
        }
        return res;
    }
}
