import java.util.Arrays;

public class 牛客数组中的最长连续子序列 {
    public static int MLS (int[] arr) {
        // 给定无序数组arr，返回其中最长的连续序列的长度
        // (要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
        // [100,4,200,1,3,2], 4
        // write code here
        int len = 1;
        int max = 1;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                len += 1;
            }else if (arr[i] == arr[i - 1]){
                continue;
            }else {
                len = 1;
            }

            max = Math.max(max, len);
        }

        return max;
    }

    public static void main(String[] args) {
        MLS(new int[]{1, 1, 1});
    }
}
