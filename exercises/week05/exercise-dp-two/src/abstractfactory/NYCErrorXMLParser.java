package abstractfactory;

public class NYCErrorXMLParser implements XMLParser {

    @Override
    public String parse() {
        System.out.println("NYC Parsing error XML...");
        return "NYC Error XML Message";
    }

}
