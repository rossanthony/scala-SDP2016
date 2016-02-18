package div

sealed trait DivisionResult

final case class Finite(value: Int) extends DivisionResult

final case object Infinite extends DivisionResult

object divide {
  def apply(num: Int, den: Int) =
    if (den == 0) Infinite else Finite(num / den)
}

object Div extends App {
  divide(1, 0) match {
    case Finite(value) => s"It's finite: ${
      value
    }"
    case Infinite => s"It's infinite"
  }
}