package interview.designPattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    public void setRent(Rent rent) {
        this.rent = rent;
    }

    private Rent rent;

    // 生成得到代理类

    /**
     * 代理存在的意义：使用代理模式可以在不修改别代理对象代码的基础上，通过扩展代理类，进行一些功能的附加与增强
     * 主题接口(subject)：定义代理类和真实主题的公共对外方法，也是代理类代理真实主题的方法；
     * 真实主题(RealSubject)：真正实现业务逻辑的类；
     * 代理类(Proxy)：用来代理和封装真实主题；
     * 客户端(Client)：使用代理类和主题接口完成一些工作。
     */

    /**
     * 动态代理（以下称代理），利用Java的反射技术(Java Reflection)，在运行时创建一个实现某些给定接口的新类（也称“动态代理类”）及其实例（对象）
     *
     * (Using Java Reflection to create dynamic implementations of interfaces at runtime)。
     *
     * 代理的是接口(Interfaces)，不是类(Class)，更不是抽象类。
     *
     * 解决特定问题：一个接口的实现在编译时无法知道，需要在运行时才能实现
     * 创建动态对象
     * Proxy.newProxyInstance()方法有三个参数：
     *
     * 1. 类加载器(Class Loader)
     *
     * 2. 需要实现的接口数组
     *
     * 3. InvocationHandler接口。所有动态代理类的方法调用，都会交由InvocationHandler接口实现类里的invoke()方法去处理。这是动态代理的关键所在。
     * @return
     * @throws Throwable
     */
    public Object getProxy() throws Throwable {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    // 处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result =  method.invoke(rent, args);
        System.out.println("after");
        return null;
    }
}
