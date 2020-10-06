import java.lang.reflect.Field;

public class StringReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        // TODO Auto-generated method stub
        String str = "不可变的字符串";

        System.out.println(str.hashCode()+":"+str);         //改变前的hash值

        Field f = str.getClass().getDeclaredField("value"); //获取value属性
        f.setAccessible(true);                              //设置其可以被访问(private)
        f.set(str, new char[] { '改', '变', '后', '的', '值' }); //改变其值

        System.out.println(str.hashCode()+":"+str);         //改变后的hash值
    }
}
