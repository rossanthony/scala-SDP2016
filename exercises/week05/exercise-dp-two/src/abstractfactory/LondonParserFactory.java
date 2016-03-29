package abstractfactory;

public class LondonParserFactory implements AbstractParserFactory {

    @Override
    public XMLParser getParserInstance(String parserType) {

        switch (parserType) {
            case "LondonERROR":
                return new LondonErrorXMLParser();
            case "LondonFEEDBACK":
                return new LondonFeedbackXMLParser();
            case "LondonORDER":
                return new LondonOrderXMLParser();
            case "LondonRESPONSE":
                return new LondonResponseXMLParser();
        }

        return null;
    }

}
