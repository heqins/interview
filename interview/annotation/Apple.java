package interview.annotation;


import java.util.Collections;

public class Apple {
    @FruitName(value = "Apple")
    private String name;

    private String appleColor;

    public static void main(String[] args) {
        System.out.println(0<<1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE + 1);
        System.out.println(Integer.MIN_VALUE + 2);
        System.out.println(-(Integer.MIN_VALUE + 2));
        Integer a1 = 125;
        Integer a2 = 125;
        Integer b1 = 12343;
        Integer b2 = 12343;

        System.out.println(a1 == a2);
        System.out.println(b1 == b2);

    }
}
