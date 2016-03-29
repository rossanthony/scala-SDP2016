package manifests

//
// Manifests give access to the Java reflection API (eg. method getMethods) without the need for
// instantiating a value of the instrumented type
//
object methods extends App {
  def printMethods[T](t: T) {
    // requires instance
    val meths = t.getClass.getMethods
    println(meths take 5 mkString "\n")
  }

  def printMethods1(name: String) {
    // low-level
    val meths = Class.forName(name).getMethods
    println(meths take 5 mkString "\n")
  }

  def printMethods2[T: Manifest] {
    // no instance
    val meths = manifest[T].erasure.getMethods
    println(meths take 5 mkString "\n")
  }

  printMethods(Some(""))
  printMethods1("scala.Some")
  printMethods2[Some[_]]
}