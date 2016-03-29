package builder

object TestBuilderPattern {
  def main(args: Array[String]) {
    var carBuilder: CarBuilder = new SedanCarBuilder
    var director: CarDirector = new CarDirector(carBuilder)
    director.build
    var car: Car = carBuilder.getCar
    System.out.println(car)
    carBuilder = new SportsCarBuilder
    director = new CarDirector(carBuilder)
    director.build
    car = carBuilder.getCar
    System.out.println(car)
  }
}