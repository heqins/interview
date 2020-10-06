@FunctionalInterface
interface Print<T> {
    public void print(T x);
}
public class Lambda {
    public static void PrintString(String s, Print<String> print) {
        print.print(s);
    }
    private static void lambda$0(String x) {
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();

        for(int i=0;i<stack.length;i++){
            System.out.print(stack[i].getClassName()+"："+stack[i].getMethodName()+"方法");
        }

        System.out.println(x);
    }
    final class $Lambda$1 implements Print{
        @Override
        public void print(Object x) {
            lambda$0((String)x);
        }
    }
    public static void main(String[] args) {
        PrintString("test", new Lambda().new $Lambda$1());
    }
}