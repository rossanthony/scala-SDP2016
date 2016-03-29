package factory;

public class ConcreteCreator implements Creator {
    static Product getProduct() {
        return Creator.getProduct("");
    }

}
