package interview;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Test extends Thread{
    static int x = 0;

    int count = 0;

    public static void main(String[] args) {
        Thread t1 = new Test();
        Thread t2 = new Test();

        t1.start();
        t2.start();
        
        System.out.println(Test.x);

        PriorityQueue q = new PriorityQueue();
        q.offer(1);
        q.offer(0);
        q.offer(3);
        System.out.println(q.poll());

        Test t = new Test();
        t.change(t);
        System.out.println(t.count);
    }

    public void change(Test t) {
        t.count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            x++;
        }
    }
}
