package abstractfactory

class NYCErrorXMLParser extends XMLParser {
  def parse: String = {
    println("NYC Parsing error XML...")
    "NYC Error XML Message"
  }
}