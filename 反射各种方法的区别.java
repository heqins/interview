import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 反射各种方法的区别 {
    public static void main(String[] args) {
        Class<?> cls = Bird2.class;
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        Field[] fields2 = cls.getFields();
        System.out.println("test");
    }
}

class Bird {
    private int field1;
    public int field2;
    public void say() {
        System.out.println("Bird");
    }
}

class Bird2 extends Bird {
    public void run() {
        System.out.println("Bird2 run");
    }
}
