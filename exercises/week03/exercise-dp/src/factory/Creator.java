package factory;

public interface Creator {

    static Product getProduct() {
        return getProduct("");
    }

    static Product getProduct(String s) {
        return new ConcreteProduct(s);
    }
}
