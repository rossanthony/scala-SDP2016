package abstractfactory;

public class LondonOrderXMLParser implements XMLParser {

    @Override
    public String parse() {
        System.out.println("London Parsing order XML...");
        return "London Order XML Message";
    }

}

