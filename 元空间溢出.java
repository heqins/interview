import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 元空间溢出 {
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    public static void main(String[] args) throws ClassNotFoundException {
        for (int i = 0; i < 100000000; i++) {
            Class.forName("元空间溢出.class");
        }


    }
}


