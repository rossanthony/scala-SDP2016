package sum

// If A is B or C, method f returns F

sealed trait A {
  def f: F
}

final case class B() extends A() {
  def f: F = ???
}

final case class C() extends A() {
  def f: F = ???
}

trait F {

}