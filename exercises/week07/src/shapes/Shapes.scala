package shapes

import com.atomicscala.AtomicTest._

/*
  Traits:
  Similar to interfaces in Java, traits are used to define object types
  by specifying the signature of the supported methods. Like in Java 8,
  Scala allows traits to be partially implemented; i.e. it is possible
  to define default implementations for some methods. In contrast to classes,
  traits may not have constructor parameters.
*/

trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

case class Rectangle(width: Double, height: Double) extends Shape {
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Square(size: Double) extends Shape {
  val sides = 4
  val perimeter = 4 * size
  val area = size * size
}

object ShapeTest extends App {

  Circle(20).area is 1256
  println(Square(20).area) // is 400.0
  println(Rectangle(20, 30).area) // is 600.0

  println(Circle(20).perimeter) // is 125.66370614359172
  println(Square(20).perimeter) // is 80.0
  println(Rectangle(20, 30).perimeter) // is 100.0

  println(Circle(20).sides) // is 1
  println(Square(20).sides) // is 4
  println(Rectangle(20, 30).sides) // is 4
}