import java.util.concurrent.locks.ReentrantLock;

public class 线程交替打印奇数和偶数volatile {
    private static volatile int count = 1;
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        flag = false;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        flag = true;
                    }
                }
            }
        }).start();
    }
}
