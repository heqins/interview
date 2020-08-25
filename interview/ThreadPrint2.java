package interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint2 {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final int limit;
    private volatile int count;

    public ThreadPrint2(int limit, int initCount) {
        this.limit = limit;
        this.count = initCount;
    }

    public void print()  {
        lock.lock();
        try {
            while (count < limit){
                System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                condition.signalAll();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadPrint2 printer = new ThreadPrint2(10, 0);
        Thread thread1 = new Thread(printer::print, "thread-1");
        Thread thread2 = new Thread(printer::print, "thread-2");
        thread1.start();
        thread2.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
