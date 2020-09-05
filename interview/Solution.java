package interview;

import java.util.LinkedList;
import java.util.Stack;

public class Solution{
//    public static int calculate(String exp) {
//        return calRst(backTempExp(exp));
//    }
    // 计算后缀表达式
    public static LinkedList<String> backTempExp(String exp) {

        Stack<String> stkEles = new Stack<String>();
        LinkedList<String> tempBackExp = new LinkedList<String>();
        for (int i = 0; i < exp.length(); i++) {
            // 1.遇到了数字
            if (Character.isDigit(exp.charAt(i))) {
                // 注意多位数的获取
                int k = i + 1;
                for (; k < exp.length() && Character.isDigit(exp.charAt(k)); k++) {

                }
                tempBackExp.add(exp.substring(i, k));
                i = k - 1;// 更新 i
                continue;
            }
            // 2.遇到了乘除运算符
            if (exp.charAt(i) == '/' || exp.charAt(i) == '*') {

                while (!stkEles.isEmpty() && (stkEles.lastElement().equals("/") || stkEles.lastElement().equals("*"))) {
                    tempBackExp.add(stkEles.pop()); // 弹出优先级相同或以上的栈内运算符
                }
                stkEles.add(String.valueOf(exp.charAt(i))); // 运算符入栈
                continue;
            }
            // 3.遇到了加减运算符
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                while (!stkEles.isEmpty() && !isNumeric(stkEles.lastElement())) {
                    tempBackExp.add(stkEles.pop()); // 弹出优先级相同或以上的栈内运算符
                }
                stkEles.add(String.valueOf(exp.charAt(i))); // 运算符入栈
                continue;
            }
        }
        // 4.最后弹出栈内所有元素到表达式
        while (stkEles.size() > 0) {
            tempBackExp.add(stkEles.pop());
        }
        return tempBackExp;
    }

    // 计算最终的结果
    public static int calRst(LinkedList<String> tempBackExp) {
        Stack<Integer> calStk = new Stack<Integer>();
        for (String c : tempBackExp) {
            // 1.数字，入栈
            if (isNumeric(c)) {
                calStk.push(Integer.valueOf(c)); // string to int
                continue;
            }
            // 2.非数字，则为符号，出栈两个元素计算出结果然后再入栈该计算值
            else {
                int a = calStk.pop();
                int b = calStk.pop();
                switch (c.toCharArray()[0]) {
                    // 注意减法和除法时，注意出栈的顺序与原表达式是相反的

                    case '+':
                        calStk.push(b + a);
                        continue;
                    case '-':
                        calStk.push(b - a);
                        continue;
                    case '*':
                        calStk.push(b * a);
                        continue;
                    case '/':
                        calStk.push(b / a);
                        continue;
                }
            }
        }
        return calStk.pop();
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //前缀转中缀　>1位的数字后面加上_
    public static String infixToSuffix(String str) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') continue;
            if ('+' == c || '-' == c) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if ('*' == c || '/' == c) {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if ('(' == c) {
                stack.push(c);
            } else if (')' == c) { //数字
                while (!stack.isEmpty() && '(' != stack.peek()) {
                    sb.append(stack.pop());
                }
                stack.pop(); //最后把(弹出来
            } else {
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append("_");//一个数字结尾加上一个符号_
                i--; //上面多加了一次;
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }

    public static int calculate(String s) {
        //先转换成逆波兰表达式
        String str = infixToSuffix(s);
        Stack<Integer> stack = new Stack<>(); //计算后缀表达式的　栈
        int num = 0;
        int a, b;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '-') {
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            } else if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (c == '/') {
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
            } else {
                while (i < str.length() && str.charAt(i) != '_') {
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                stack.push(num);
                num = 0;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String test = "2*6-(23+7)/(1+2)";
        System.out.println(calculate(test));
    }
}