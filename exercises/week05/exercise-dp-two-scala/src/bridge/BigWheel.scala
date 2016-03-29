package bridge

class BigWheel(product: Product, carType: String) extends Car(product, carType) {

  def assemble {
    throw new UnsupportedOperationException
  }

  def produceProduct {
    throw new UnsupportedOperationException
  }
}