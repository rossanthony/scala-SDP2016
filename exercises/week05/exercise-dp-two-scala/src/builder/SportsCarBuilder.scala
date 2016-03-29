package builder

class SportsCarBuilder extends CarBuilder {
  private final val car: Car = new Car("SPORTS")

  def buildBodyStyle {
    car.setBodyStyle("External dimensions: overall length (inches): 192.3,"
      + " overall width (inches): 75.5, overall height (inches): 54.2, wheelbase (inches): 112.3,"
      + " front track (inches): 63.7, rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7")
  }

  def buildPower {
    car.setPower("323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm")
  }

  def buildEngine {
    car.setEngine("3.6L V 6 DOHC and variable valve timing")
  }

  def buildBreaks {
    car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution. StabiliTrak stability control")
  }

  def buildSeats {
    car.setSeats("Driver sports front seat with one power adjustments manual height, front passenger seat sports front seat with one power adjustments")
  }

  def buildWindows {
    car.setWindows("Front windows with one-touch on two windows")
  }

  def buildFuelType {
    car.setFuelType("Gasoline 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range")
  }

  def getCar: Car = {
    car
  }
}