package abstractfactory

class NYCResponseXMLParser extends XMLParser {
  def parse: String = {
    println("NYC Parsing response XML...")
    "NYC Response XML Message"
  }
}