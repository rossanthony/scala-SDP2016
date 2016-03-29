package decoupledinterface

object HelloWorldDecoupledInterface {
  def main(args: Array[String]) {
    val mr: MessageRenderer = new StandardOutMessageRenderer
    val mp: MessageProvider = new HelloWorldMessageProvider
    mr.setMessageProvider(mp)
    mr.render
  }
}