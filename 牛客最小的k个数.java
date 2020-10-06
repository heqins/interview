import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 牛客最小的k个数 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if (k == 0 || k > input.length) return res;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for (; i < k; i++) {
            q.offer(input[i]);
        }

        for (; i < input.length; i++) {
            if (input[i] < q.peek()) {
                q.poll();
                q.offer(input[i]);
            }
        }

        for (int j = 0; j < k; j++) {
            res.add(q.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4);
    }
}
