import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程交替打印奇数和偶数ReentrantLock {
    // 需要打印的资源: 0~100
    private static int count = 0;

    // 通过condition控制线程竞争
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    try {
                        lock.lock();
                        System.out.println("偶: " + count);
                        count++;
                        // 把偶数线程阻塞
                        condition1.await();
                        // 把奇数线程唤醒
                        condition2.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    try {
                        lock.lock();
                        System.out.println("奇: " + count);
                        count++;
                        condition1.signal();
                        // 把偶数线程阻塞
                        condition2.await();
                        // 把奇数线程唤醒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
    }
}
