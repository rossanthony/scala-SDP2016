package abstractfactory

class LondonOrderXMLParser extends XMLParser {
  def parse: String = {
    println("London Parsing order XML...")
    "London Order XML Message"
  }
}