package abstractfactory

trait AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser
}