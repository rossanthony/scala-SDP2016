package decoupledinterface

class HelloWorldMessageProvider extends MessageProvider {
  override def getMessage: String = {
    return "Hello World!"
  }
}