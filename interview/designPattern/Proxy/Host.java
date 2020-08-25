package interview.designPattern.Proxy;

public class Host implements Rent{
    private String test  = "Test";
    @Override
    public void rent() {
        System.out.println("出租房子");
    }
}
