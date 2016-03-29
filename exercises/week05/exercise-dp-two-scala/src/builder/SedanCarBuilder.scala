package builder

class SedanCarBuilder extends CarBuilder {
  private final val car: Car = new Car("SEDAN")

  def buildBodyStyle {
    car.setBodyStyle("External dimensions: overall length (inches): 202.9, "
      + "overall width (inches): 76.2, overall height (inches): 60.7, wheelbase (inches): 112.9,"
      + " front track (inches): 65.3, rear track (inches): 65.5 and curb to curb turning circle (feet): 39.5")
  }

  def buildPower {
    car.setPower("285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm")
  }

  def buildEngine {
    car.setEngine("3.5L Duramax V 6 DOHC")
  }

  def buildBreaks {
    car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution")
  }

  def buildSeats {
    car.setSeats("Front seat center armrest.Rear seat center armrest.Split-folding rear seats")
  }

  def buildWindows {
    car.setWindows("Laminated side windows.Fixed rear window with defroster")
  }

  def buildFuelType {
    car.setFuelType("Gasoline 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range")
  }

  def getCar: Car = {
    car
  }
}