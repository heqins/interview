package interview.designPattern.singleton;

// 静态内部类
public class Holder {
    /**
     * 可以看出INSTANCE在创建过程中是线程安全的，所以说静态内部类形式的单例可保证线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
     */
    private Holder(){}

    private static Holder holder;

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    public static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }

}
