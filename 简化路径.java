import java.util.Arrays;
import java.util.Stack;

public class 简化路径 {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");

        for (String str: strs) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else if (!str.equals(".") && !str.equals("")) {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append("/" + stack.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("/a/../../b/../c//.//".split("/")));
    }
}
