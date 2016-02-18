package sealedshape

import revisedshapes.{Circle, Rectangle, Shape, Square}

object Draw {
  def apply(shape: Shape) = shape match {
    case Rectangle(width, height) =>
      s"A rectangle of width ${width}cm and height ${height}cm"
    case Square(size) =>
      s"A square of size ${size}cm"
    case Circle(radius) =>
      s"A circle of radius ${radius}cm"
  }
}