package abstractfactory;

public class NYCParserFactory implements AbstractParserFactory {

    @Override
    public XMLParser getParserInstance(String parserType) {

        switch (parserType) {
            case "NYCERROR":
                return new NYCErrorXMLParser();
            case "NYCFEEDBACK":
                return new NYCFeedbackXMLParser();
            case "NYCORDER":
                return new NYCOrderXMLParser();
            case "NYCRESPONSE":
                return new NYCResponseXMLParser();
        }

        return null;
    }

}
