package revisedshapes

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
  val perimeter = 2 * width + 2 * height
  val area = width * height
}
case class Square(val size: Int) extends Rectangular {
  val width = size
  val height = size
}
case class Rectangle(val width: Int, val height: Int) extends Rectangular