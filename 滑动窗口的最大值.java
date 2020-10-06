import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 滑动窗口的最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        if (len == 0)
        {
            return new int[0];
        }

        int[] result = new int[len - k + 1];

        Queue<Integer> q = new PriorityQueue<>(len, Collections.reverseOrder());

        for (int i = 0; i < k; i++)
        {
            q.add(nums[i]);
        }

        result[0] = q.peek();

        for (int i = k; i < len; i++)
        {
            q.remove(nums[i - k]);
            q.add(nums[i]);
            result[i - k + 1] = q.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(test, 3)));
    }
}
