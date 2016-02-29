import atomic.AtomicTest._

/**
Demonstrate that named and default arguments can be used with
methods. Create a class Item that takes two class arguments:
A String for name and a Double for price.

Add a method cost which has named arguments for grocery (Boolean),
medication (Boolean), and taxRate(Double). Default grocery and
medication to false, taxRate to 0.10.

In this scenario, groceries and medications are not taxable.
Return the total cost of the item by calculating the appropriate
tax.
*/

class Item(name:String, price:Double) {
  def cost(
            grocery: Boolean = false,
            medication:Boolean = false,
            taxRate:Double = 0.10
          ): Double = {
    if (grocery || medication)
      price
    else
      price + (price * taxRate)
  }
}

// Satisfy the following tests:
val flour = new Item(name="flour", 4)
flour.cost(grocery=true) is 4
val sunscreen = new Item(name="sunscreen", 3)
sunscreen.cost() is 3.3
val tv = new Item(name="television", 500)
tv.cost(taxRate = 0.06) is 530