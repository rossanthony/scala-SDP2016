package decoupledwithfactory

object HelloWorldDecoupledWithFactory {
  def main(args: Array[String]) {
    val mr: MessageRenderer = MessageSupportFactory.getInstance.getMessageRenderer
    val mp: MessageProvider = MessageSupportFactory.getInstance.getMessageProvider
    mr.setMessageProvider(mp)
    mr.render
  }
}