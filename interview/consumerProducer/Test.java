package interview.consumerProducer;

public class Test {
    /**
     * 这也是最简单最基础的实现，缓冲区满和为空时都调用wait()方法等待，当生产者生产了一个产品或者消费者消费了一个产品之后会唤醒所有线程。
     */
    private static String LOCK = "lock";
    private static final Integer FULL = 10;
    private static Integer count = 0;

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
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

                synchronized (LOCK)
                {
                    while (count == FULL)
                    {
                        try {
                            LOCK.wait();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }

                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产后, 目前共有" + count);
                    LOCK.notifyAll();
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

                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费后, 目前共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
