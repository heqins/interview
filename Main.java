import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public synchronized static void method1() {
        System.out.println("method1");
    }

    public synchronized void method2() {
        method2();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        ConcurrentHashMap map = new ConcurrentHashMap();
//        map.put(null, 1);
        HashMap map2 = new HashMap();
        map2.put(null, 2);
        System.out.println(map2.get(0));
    }
}
