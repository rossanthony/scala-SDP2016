package abstractfactory;

public class LondonFeedbackXMLParser implements XMLParser {

    @Override
    public String parse() {
        System.out.println("London Parsing feedback XML...");
        return "London Feedback XML Message";
    }

}

