public class InheritableThreadLocalTest {
    public static ThreadLocal<String> threadLocal = new java.lang.InheritableThreadLocal<>();

    public static String get() {
        return threadLocal.get();
    }

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            InheritableThreadLocalTest.set("ye");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
                }
            });

            t.start();
        }
    }
}
