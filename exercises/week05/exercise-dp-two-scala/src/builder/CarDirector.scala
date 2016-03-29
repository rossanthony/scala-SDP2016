package builder

class CarDirector {
  private var carBuilder: CarBuilder = null

  def this(carBuilder: CarBuilder) {
    this()
    this.carBuilder = carBuilder
  }

  def build {
    carBuilder.buildBodyStyle
    carBuilder.buildPower
    carBuilder.buildEngine
    carBuilder.buildBreaks
    carBuilder.buildSeats
    carBuilder.buildWindows
    carBuilder.buildFuelType
  }
}