package interview;

import java.util.concurrent.Semaphore;

public class ThreadPrint3 {
    private static Semaphore semaphore = new Semaphore(1);
    private static volatile int count = 0;
    private static final int limit = 10;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < limit)
                {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "," + count);
                        count++;
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < limit)
                {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "," + count);
                        count++;
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
