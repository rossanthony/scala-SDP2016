package manifests

//
// Subtyping relations can be tested using Scala manifests
//
object subtypes extends App {
  def printSubtype[T, U](t: T, u: U) {
    val mt = Manifest.classType(t.getClass)
    val mu = Manifest.classType(u.getClass)
    println(mt <:< mu)
  }

  def printSubtype2[T: Manifest, U: Manifest] {
    println(manifest[T] <:< manifest[U])
  }

  // arrays are invariant
  printSubtype(Array(0), Array[AnyVal](1)) // false
  printSubtype(List(""), List[AnyRef]("")) // true
  printSubtype((Seq(0), 1), (Seq[AnyVal](), 2)) // true

  printSubtype2[Array[Int], Array[AnyVal]]
  printSubtype2[List[String], List[AnyRef]]
  printSubtype2[(Seq[Int], Int), (Seq[AnyVal], Int)]
}