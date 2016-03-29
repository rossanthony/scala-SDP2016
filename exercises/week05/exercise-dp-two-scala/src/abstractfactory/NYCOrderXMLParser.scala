package abstractfactory

class NYCOrderXMLParser extends XMLParser {
  def parse: String = {
    println("NYC Parsing order XML...")
    "NYC Order XML Message"
  }
}