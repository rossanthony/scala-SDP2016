package abstractfactory;

public interface AbstractParserFactory {

    XMLParser getParserInstance(String parserType);
}
