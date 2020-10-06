import java.util.Stack;

public class 牛客接雨水 {
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = height.length, res = 0;

        // 这里的栈是一个单调递减栈
        while (i < n) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i++);
            } else {
                int mid = stack.pop();
                if (stack.isEmpty()) continue;

                res += (i - stack.peek() - 1) * (Math.min(height[stack.peek()], height[i]) - height[mid]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        trap(height);
    }
}
