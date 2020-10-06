import java.util.concurrent.atomic.AtomicInteger;

public class 线程交替打印奇数和偶数AtomInteger {
    private static AtomicInteger count = new AtomicInteger(0);

    private volatile static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count.get() <= 100) {
                    if (flag) {
                        System.out.println("偶数：" + count.getAndIncrement());
                        flag = false;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count.get() <= 100) {
                    if (!flag) {
                        System.out.println("奇数：" + count.getAndIncrement());
                        flag = true;
                    }
                }
            }
        }).start();
    }
}
