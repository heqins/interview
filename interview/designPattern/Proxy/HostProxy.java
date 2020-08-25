package interview.designPattern.Proxy;

public class HostProxy implements Rent{

    // 静态代理模式-缺点：每一个真实角色需要写一个代理角色

    private Host host;

    public HostProxy(Host host) {
        this.host = host;
    }
    @Override
    public void rent() {
        seeHouse();
        host.rent();
        hetong();
        fare();
    }

    public void seeHouse() {
        System.out.println("中介带看房");
    }

    public void hetong() {
        System.out.println("签订合同");
    }

    public void fare() {
        System.out.println("收中介费");
    }
}
