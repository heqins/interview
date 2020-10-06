import java.util.ArrayList;
import java.util.List;

public class 和为S的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        // 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）
        int l = 1, r = 1;
        List<int[]> list = new ArrayList<>();

        int sum = 0;

        while (l <= target / 2) {
            if (sum < target ) {
                sum += r;
                r++;
            }else if (sum > target ) {
                // 注意 -=
                sum -= l;
                l++;
            }else {
                int[] temp = new int[r - l];
                for (int i = l; i < r; i++) {
                    // 注意 i - l
                    temp[i - l] = i;
                }

                list.add(temp);
                sum -= l;
                l++;
            }
        }
        // 注意二维数组第二维长度可以不同
        return list.toArray(new int[list.size()][]);
    }
}
