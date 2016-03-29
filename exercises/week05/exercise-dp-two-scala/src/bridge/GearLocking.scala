package bridge

case class GearLocking(productName: String) extends Product {

  def produce {
    throw new UnsupportedOperationException
  }
}