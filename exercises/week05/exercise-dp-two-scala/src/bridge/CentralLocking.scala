package bridge

case class CentralLocking(productName: String) extends Product {

  def produce {
    throw new UnsupportedOperationException
  }
}