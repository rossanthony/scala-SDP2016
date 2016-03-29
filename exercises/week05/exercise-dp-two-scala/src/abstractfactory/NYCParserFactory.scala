package abstractfactory

class NYCParserFactory extends AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser = {
    parserType match {
      case "NYCERROR" =>
        return new NYCErrorXMLParser
      case "NYCFEEDBACK" =>
        return new NYCFeedbackXMLParser
      case "NYCORDER" =>
        return new NYCOrderXMLParser
      case "NYCRESPONSE" =>
        return new NYCResponseXMLParser
    }
  }
}