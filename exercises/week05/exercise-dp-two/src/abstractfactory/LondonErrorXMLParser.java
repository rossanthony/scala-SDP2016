package abstractfactory;

public class LondonErrorXMLParser implements XMLParser {

    @Override
    public String parse() {
        System.out.println("London Parsing error XML...");
        return "London Error XML Message";
    }

}
