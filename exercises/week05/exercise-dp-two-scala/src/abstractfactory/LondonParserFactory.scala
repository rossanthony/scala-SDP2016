package abstractfactory

class LondonParserFactory extends AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser = {
    parserType match {
      case "LondonERROR" =>
        return new LondonErrorXMLParser
      case "LondonFEEDBACK" =>
        return new LondonFeedbackXMLParser
      case "LondonORDER" =>
        return new LondonOrderXMLParser
      case "LondonRESPONSE" =>
        return new LondonResponseXMLParser
    }
  }
}