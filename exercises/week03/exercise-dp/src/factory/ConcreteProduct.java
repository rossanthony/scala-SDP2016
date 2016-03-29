package factory;

public class ConcreteProduct implements Product {
    private String str;

    public ConcreteProduct() {
        this("");
    }

    public ConcreteProduct(String s) {
        str = s;
    }

    @Override
    public String getThing() {
        return "[" + str + "] " + getClass().getName();
    }
}
