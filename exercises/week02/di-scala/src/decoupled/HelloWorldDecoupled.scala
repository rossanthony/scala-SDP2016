package decoupled

object HelloWorldDecoupled {
  def main(args: Array[String]) {
    val mr: StandardOutMessageRenderer = new StandardOutMessageRenderer
    val mp: HelloWorldMessageProvider = new HelloWorldMessageProvider
    mr.setMessageProvider(mp)
    mr.render
  }
}