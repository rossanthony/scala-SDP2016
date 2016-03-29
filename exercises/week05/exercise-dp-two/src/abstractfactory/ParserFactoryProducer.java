package abstractfactory;

public final class ParserFactoryProducer {

    private ParserFactoryProducer() {
        throw new AssertionError();
    }

    public static AbstractParserFactory getFactory(String factoryType) {

        switch (factoryType) {
            case "NYCFactory":
                return new NYCParserFactory();
            case "LondonFactory":
                return new LondonParserFactory();
        }

        return null;
    }

}
