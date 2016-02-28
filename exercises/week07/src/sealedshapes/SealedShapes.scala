package sealedshapes

import shapesrefactored.{Circle, Rectangle, Shape, Square}

object Draw {
  def apply(shape: Shape) = shape match {
    case Rectangle(width, height) =>
      s"A rectangle of width ${width}cm and height ${height}cm"
    case Square(size) =>
      s"A square of size ${size}cm"
    case Circle(radius) =>
      s"A circle of radius ${radius}cm"
    case _ =>
      s"Unknown shape!"
  }
}

/**
  * Bogus implementation of shape, for testing the
  * catch all in the apply method above
  */
case class Triangle(val sides: Int) extends Shape {
  val perimeter = 0.0
  val area = 0.0
}

object DrawTest extends App {
  println(Draw(Circle(10)))       // returns: "A circle of radius 10cm"
  println(Draw(Rectangle(3, 4)))  // returns: "A rectangle of width 3cm and height 4cm"
  println(Draw(Square(25)))       // returns: "A square of size 25cm"
  println(Draw(Triangle(3)))      // returns: "Unknown shape!"
}

/**
  * NOTE: commenting out one of the cases from the Draw.apply method results in the
  * following exception being thrown...

Exception in thread "main" scala.MatchError: Circle(10.0) (of class shapesrefactored.Circle)
	at sealedshapes.Draw$.apply(SealedShapes.scala:6)

However if a catch all "_" case is added, e.g...

  case _ => s"Unknown shape!"

...then we can handle unexpected shapes by outputting a message instead.

  */