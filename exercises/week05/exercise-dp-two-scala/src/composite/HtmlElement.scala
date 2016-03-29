package composite

case class HtmlElement(tagName: String) extends HtmlTag(tagName) {

  def setStartTag(tag: String) = ???

  def setEndTag(tag: String) = ???

  def generateHtml = ???
}