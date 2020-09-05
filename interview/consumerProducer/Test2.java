package interview.consumerProducer;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    private static Integer count = 0;
    private static final Integer FULL = 10;

    //创建一个锁对象
    private Lock lock = new ReentrantLock();

    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                lock.lock();
                try {
                    while (count == FULL) {
                        try {
                            notFull.await();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }

                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产了" + count);
                    notEmpty.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            notEmpty.await();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }

                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费了" + count);
                    notFull.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
