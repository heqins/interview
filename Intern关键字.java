import java.util.*;

public class Intern关键字 {
    public static void main(String[] args) {
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();

        for(int i=0;i<stack.length;i++){
            System.out.print(stack[i].getClassName()+"："+stack[i].getMethodName()+"方法");
        }
    }
}
