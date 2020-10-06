public class 线程交替打印奇数和偶数synchronized {
    private static int count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            lock.notifyAll();
                            if (count <= 100) {
                                try {
                                    lock.wait();
                                }catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            lock.notifyAll();
                            if (count <= 100) {
                                try {
                                    lock.wait();
                                }catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
