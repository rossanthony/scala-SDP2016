package shapesrefactored

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

trait Rectangular extends Shape {
  def width: Int
  def height: Int
  val sides = 4
  val perimeter: Double = 2 * width + 2 * height
  val area: Double = width * height
}
case class Square(val size: Int) extends Rectangular {
  def width: Int = size
  def height: Int = size
}
case class Rectangle(val width: Int, val height: Int) extends Rectangular


object ShapeTest extends App {
  println(Circle(20).area) // is 1256.6370614359173
  println(Square(20).area) // is 400
  println(Rectangle(20, 30).area) // is 600.0

  println(Circle(20).perimeter) // is 125.66370614359172
  println(Square(20).perimeter) // is 80.0
  println(Rectangle(20, 30).perimeter) // is 100.0

  println(Circle(20).sides) // is 1
  println(Square(20).sides) // is 4
  println(Rectangle(20, 30).sides) // is 4
}