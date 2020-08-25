package interview.designPattern.adapter;

public class Computer {
    public void net(NetToUsb adapter) {
        adapter.handlerRequest();
    }

    public static void main(String[] args) throws InterruptedException {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        });

        t1.start();
        Adapter2 adapter2 = new Adapter2(adaptee);
//        computer.net(adapter);
        computer.net(adapter2);
    }
}
