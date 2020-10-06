import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(cal(60));
    }

    public static String helper(int A, int N) {
        // i表示i进制
        int rest = A;
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder(0);
        while (rest != 0) {
            stack.add(array[new Long((rest % N)).intValue()]);
            rest = rest / N;
        }
        for (; !stack.isEmpty();) {
            result.append(stack.pop());
        }
        return result.length() == 0 ? "0":result.toString();
    }

    public static double cal(int m){
        String x = Integer.toBinaryString(m);
        StringBuilder sb = new StringBuilder();

        for (char c: x.toCharArray()) {
            if (c == '0'){
                sb.append('1');
            }else {
                sb.append('0');
            }
        }

        String num = sb.toString();
        double res = 0;
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            if (c == '1'){
                res += Math.pow(2.0, (double)len - i - 1);
            }
        }

        return res;
    }

}