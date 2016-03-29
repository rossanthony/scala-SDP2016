package builder

class Car {
  private var bodyStyle: String = null
  private var power: String = null
  private var engine: String = null
  private var breaks: String = null
  private var seats: String = null
  private var windows: String = null
  private var fuelType: String = null
  private var carType: String = null

  def this(carType: String) {
    this()
    this.carType = carType
  }

  def getBodyStyle: String = {
    return bodyStyle
  }

  def setBodyStyle(bodyStyle: String) {
    this.bodyStyle = bodyStyle
  }

  def getPower: String = {
    return power
  }

  def setPower(power: String) {
    this.power = power
  }

  def getEngine: String = {
    return engine
  }

  def setEngine(engine: String) {
    this.engine = engine
  }

  def getBreaks: String = {
    return breaks
  }

  def setBreaks(breaks: String) {
    this.breaks = breaks
  }

  def getSeats: String = {
    return seats
  }

  def setSeats(seats: String) {
    this.seats = seats
  }

  def getWindows: String = {
    return windows
  }

  def setWindows(windows: String) {
    this.windows = windows
  }

  def getFuelType: String = {
    return fuelType
  }

  def setFuelType(fuelType: String) {
    this.fuelType = fuelType
  }

  override def toString: String = {
    val sb: StringBuilder = new StringBuilder
    sb.append("--------------" + carType + "--------------------- \n")
    sb.append(" Body: ")
    sb.append(bodyStyle)
    sb.append("\n Power: ")
    sb.append(power)
    sb.append("\n Engine: ")
    sb.append(engine)
    sb.append("\n Breaks: ")
    sb.append(breaks)
    sb.append("\n Seats: ")
    sb.append(seats)
    sb.append("\n Windows: ")
    sb.append(windows)
    sb.append("\n Fuel Type: ")
    sb.append(fuelType)
    return sb.toString
  }
}