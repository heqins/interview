class Animal {
    public void move() {
        System.out.println("可以移动");
    }
}

class Dog extends Animal {
    public void move() {
        System.out.println("狗可以移动");
    }

    public void bark() {
        System.out.println("狗可以叫");
    }
}

public class TestDog {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        b.move();

    }
}
