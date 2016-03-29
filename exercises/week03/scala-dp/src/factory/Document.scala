package factory

trait Document {
  def open

  def close
}

trait Application {
  type D <: Document
  var docs = List[D]()

  def newDocument = {
    val doc = createDocument
    docs = doc :: docs
    doc.open
  }

  //Factory method
  def createDocument: D
}
