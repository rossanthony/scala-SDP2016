package manifests

//
// Manifests are necessary to create native Arrays whose element's class is not known at compile time
//
object arrays extends App {

  val square = new Shape[Side](4)

  class Side(n: Int) {
    override def toString = "Side " + n
  }

  class Shape[T: Manifest](n: Int) {
    val sides = new Array[T](n)
    try {
      val ctr = manifest[T].erasure.getConstructor(classOf[Int])
      for (i <- 0 until n)
        sides(i) = ctr.newInstance(i: java.lang.Integer).asInstanceOf[T]
    }
    catch {
      case _ =>
    }
  }
  println(square.sides mkString "\n")
}