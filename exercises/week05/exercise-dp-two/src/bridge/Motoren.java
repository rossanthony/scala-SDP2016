package bridge;

public class Motoren extends Car {

    public Motoren(Product product, String carType) {
        super(product,carType);
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