/**
  * Created by rossanthony on 11/02/2016.
  */

package poly

sealed trait A {
  def foo: String
}

final case class B() extends A {
  def foo: String = "It's an B!"
}

final case class C() extends A {
  def foo: String = "It's an C!"
}

object TestMyPoly extends App {
  val anA: A = B()
  println(anA.foo)
  val anotherA = C()
  println(anotherA.foo)
}