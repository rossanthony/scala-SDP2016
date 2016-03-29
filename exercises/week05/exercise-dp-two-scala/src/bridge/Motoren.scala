package bridge

case class Motoren(product: Product, carType: String) extends Car(product, carType) {

  def assemble {
    throw new UnsupportedOperationException
  }

  def produceProduct {
    throw new UnsupportedOperationException
  }
}