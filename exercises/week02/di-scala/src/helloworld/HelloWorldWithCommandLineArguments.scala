package helloworld

object HelloWorldWithCommandLineArguments {
  def main(args: Array[String]) {
    if (args.length > 0) {
      println(args(0))
    }
    else {
      println("Hello World!")
    }
  }
}