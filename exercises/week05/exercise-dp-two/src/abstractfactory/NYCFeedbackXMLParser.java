package abstractfactory;

public class NYCFeedbackXMLParser implements XMLParser {

    @Override
    public String parse() {
        System.out.println("NYC Parsing feedback XML...");
        return "NYC Feedback XML Message";
    }

}

