import java.util.Arrays;

public class 牛客分糖果 {
    public static int candy (int[] arr) {
        /**
         * 一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下：
         * 1. 每个孩子不管得分多少，起码分到一个糖果。
         * 2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
         * 给定一个数组arr代表得分数组，请返回最少需要多少糖果。
         */

        // write code here
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) left[i] = left[i + 1] + 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) right[i] = right[i - 1] + 1;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        candy(new int[]{1, 1, 2});
    }
}
