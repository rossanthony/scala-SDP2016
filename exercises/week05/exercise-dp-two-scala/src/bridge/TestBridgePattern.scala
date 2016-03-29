package bridge

object TestBridgePattern {
  def main(args: Array[String]) {
    val product: Product = new CentralLocking("Central Locking System")
    val product2: Product = new GearLocking("Gear Locking System")
    var car: Car = new BigWheel(product, "BigWheel xz model")
    car.produceProduct
    car.assemble
    car.printDetails
    System.out.println
    car = new BigWheel(product2, "BigWheel xz model")
    car.produceProduct
    car.assemble
    car.printDetails
    car = new Motoren(product, "Motoren lm model")
    car.produceProduct
    car.assemble
    car.printDetails
    System.out.println
    car = new Motoren(product2, "Motoren lm model")
    car.produceProduct
    car.assemble
    car.printDetails
  }
}