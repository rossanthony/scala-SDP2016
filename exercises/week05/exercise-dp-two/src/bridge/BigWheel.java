package bridge;

public class BigWheel extends Car {
    public BigWheel(Product product, String carType) {
        super(product, carType);
        throw new UnsupportedOperationException();
    }

    @Override
    public void assemble() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void produceProduct() {
        throw new UnsupportedOperationException();
    }
}