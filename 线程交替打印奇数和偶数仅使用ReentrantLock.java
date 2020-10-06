import java.util.concurrent.locks.ReentrantLock;

public class 线程交替打印奇数和偶数仅使用ReentrantLock {
    // 需要打印的资源: 0~100
    private static int count = 0;

    // 是否执行打印的标志
    private static volatile boolean flag = false;

    // 通过加锁控制线程竞争
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    if (!flag) {
                        try {
                            lock.lock();
                            System.out.println("偶: " + count);
                            count++;
                            // 只有flag变为true了，此线程才不会接着执行，将争夺权给奇数线程
                            flag = true;
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        // 防止线程空转
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    if (flag) {
                        try {
                            lock.lock();
                            System.out.println("奇: " + count);
                            count++;
                            // 只有flag变为true了，此线程才不会接着执行，将争夺权给奇数线程
                            flag = false;
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        // 防止线程空转
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
