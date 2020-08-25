package interview.designPattern.Proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {
    public static void main(String[] args) throws Throwable {
//        Host host = new Host();
//        HostProxy proxy = new HostProxy(host);
//        proxy.rent();
        Host host = new Host();

        Class c1 = Class.forName("interview.designPattern.Proxy.Host");
        System.out.println(c1.getDeclaredField("test").getType());

//        ProxyInvocationHandler pih = new ProxyInvocationHandler();
//
//        pih.setRent(host);
//
//        Rent proxy = (Rent) pih.getProxy();
//
//        proxy.rent();
    }
}
