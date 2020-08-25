package interview.designPattern.singleton;

// 懒汉式单例+双重检验锁
public class DCL {
    // 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
    private DCL(){}

    private static volatile DCL dcl;

    public static DCL getInstance() {
        /**
         * 第一次判断 INSTANCE == null为了避免非必要加锁，当第一次加载时才对实例进行加锁再实例化
         */
        if (dcl == null) {
            synchronized (DCL.class) {
                if (dcl == null) {
                    dcl = new DCL();
                }
            }
        }

        return dcl;
    }
}
