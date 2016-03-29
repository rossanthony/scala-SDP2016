package abstractfactory;

public class NYCOrderXMLParser implements XMLParser {

    @Override
    public String parse() {
        System.out.println("NYC Parsing order XML...");
        return "NYC Order XML Message";
    }

}

