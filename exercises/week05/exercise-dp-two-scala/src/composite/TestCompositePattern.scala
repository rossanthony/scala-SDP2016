package composite

object TestCompositePattern {
  def main(args: Array[String]) {
    val parentTag: HtmlTag = new HtmlParentElement("<html>")
    parentTag.setStartTag("<html>")
    parentTag.setEndTag("</html>")
    val p1: HtmlTag = new HtmlParentElement("<body>")
    p1.setStartTag("<body>")
    p1.setEndTag("</body>")
    parentTag.addChildTag(p1)
    var child1: HtmlTag = new HtmlElement("<P>")
    child1.setStartTag("<P>")
    child1.setEndTag("</P>")
    child1.setTagBody("Testing html tag library")
    p1.addChildTag(child1)
    child1 = new HtmlElement("<P>")
    child1.setStartTag("<P>")
    child1.setEndTag("</P>")
    child1.setTagBody("Paragraph 2")
    p1.addChildTag(child1)
    parentTag.generateHtml
  }
}