package interview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    public enum Color{ BULE,RED,GREEN};

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}
