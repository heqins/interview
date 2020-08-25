package interview.designPattern.singleton;

public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}
