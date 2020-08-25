package interview.designPattern.adapter;

public class Adapter extends Adaptee implements NetToUsb{
    @Override
    public void handlerRequest() {
        super.request();
    }
}
