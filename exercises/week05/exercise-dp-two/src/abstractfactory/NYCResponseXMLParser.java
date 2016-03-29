package abstractfactory;

public class NYCResponseXMLParser implements XMLParser {

    @Override
    public String parse() {
        System.out.println("NYC Parsing response XML...");
        return "NYC Response XML Message";
    }

}
