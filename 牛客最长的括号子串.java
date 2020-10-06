import java.util.Stack;

public class 牛客最长的括号子串 {
    public int longestValidParentheses (String s) {
        // 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度
        // 再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4
        // write code here
        int start = 0, res=  0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else if (s.charAt(i) == ')') {
                // start为最左边的左括号的位置
                if (stack.isEmpty()) {
                    start = i + 1;
                }else {
                    stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }
}
