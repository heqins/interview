package interview.designPattern.singleton;

// 懒汉式单例
// 单线程是ok的
public class LazyMan {
    private LazyMan(){}

    /*
    好处：懒汉模式中单例是在需要的时候才去创建的，如果单例已经创建，再次调用获取接口将不会重新创建新的对象，而是直接返回之前创建的对象。
        适用于：如果某个单例使用的次数少，并且创建单例消耗的资源较多，那么就需要实现单例的按需创建，这个时候使用懒汉模式就是一个不错的选择。
    缺点：但是这里的懒汉模式并没有考虑线程安全问题，在多个线程可能会并发调用它的getInstance()方法，导致创建多个实例，因此需要加锁解决线程同步问题，实现如下:
     */
    private static LazyMan lazyMan;

    /*
    JDK5的修正：以上就是双重校验锁会失效的原因，不过还好在JDK1.5及之后版本增加了volatile关键字。
    volatile的一个语义是禁止指令重排序优化，也就保证了instance变量被赋值的时候对象已经是初始化过的，从而避免了上面说到的问题。
     */
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            // 不是一个原子操作
            // 有可能创建多个实例化对象

            lazyMan = new LazyMan();
        }
        return lazyMan;
    }
}
