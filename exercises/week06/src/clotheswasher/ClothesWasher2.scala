package clotheswasher

import atomic.AtomicTest._

/**
  Auxiliary Constructors
  Create a class called ClothesWasher with a default constructor and two auxiliary constructors,
  one that specifies modelName (as a String) and one that specifies capacity
  (as a Double).
  */
class ClothesWasher2(var modelName: String, var capacity: Double) {

  // one-arg auxiliary constructor
  def this(modelName: String) {
    this(modelName, ClothesWasher2.DEFAULT_CAPACITY)
  }

  // one-arg auxiliary constructor
  def this(capacity: Double) {
    this(ClothesWasher2.DEFAULT_MODEL_NAME, capacity)
  }

  // zero-arg auxiliary constructor
  def this() {
    this(ClothesWasher2.DEFAULT_MODEL_NAME, ClothesWasher2.DEFAULT_CAPACITY)
  }

  override def toString = s"A $modelName clothes washer with $capacity kg drum capacity"
}

object ClothesWasher2 {
  val DEFAULT_MODEL_NAME = "Hotpoint"
  val DEFAULT_CAPACITY = 5.0
}

object TestClothesWasher extends App {
  new ClothesWasher2 is "A Hotpoint clothes washer with 5.0 kg drum capacity"
  new ClothesWasher2(modelName = "Zanussi") is "A Zanussi clothes washer with 5.0 kg drum capacity"
  new ClothesWasher2(modelName = "Bosch", capacity = 6.2) is "A Bosch clothes washer with 6.2 kg drum capacity"
}
