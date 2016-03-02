package tea

import atomic.AtomicTest._

/**
  Create a new class Tea that has two methods:
  describe — which includes information about whether the tea includes milk, sugar,
  is decaffeinated, and includes the name; and
  calories — which adds 100 calories for milk and 16 calories for sugar.
*/
class Tea(
           name:String = "Earl Grey",
           decaf:Boolean = false,
           sugar:Boolean = false,
           milk:Boolean = false
         ) {

  def describe = {
    var desc = name
    if (decaf) desc += " decaf"
    if (milk) desc += " + milk"
    if (sugar) desc += " + sugar"
    desc
  }

  def calories: Int = {
    var cal = 0
    if (sugar) cal += 16
    if (milk) cal += 100
    cal
  }
}

// Satisfy the following tests:

object TeaScript extends App {
  val tea = new Tea
  tea.describe is "Earl Grey"
  tea.calories is 0

  val lemonZinger = new Tea(decaf = true, name="Lemon Zinger")
  lemonZinger.describe is "Lemon Zinger decaf"
  lemonZinger.calories is 0

  val sweetGreen = new Tea( name="Jasmine Green", sugar=true)
  sweetGreen.describe is "Jasmine Green + sugar"
  sweetGreen.calories is 16

  val teaLatte = new Tea(sugar=true, milk=true)
  teaLatte.describe is "Earl Grey + milk + sugar"
  teaLatte.calories is 116
}