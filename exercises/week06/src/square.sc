import atomic.AtomicTest._

/**
  * Write a method that squares a variable argument list of
  * numbers and returns the sum.
  * @param nums (variable length args)
  * @return
  */
def squareThem(nums: Int*): Int = {
  var total: Int = 0
  for(x <- nums) {
    total += (x * x)
  }
  total
}

// Satisfy the following tests:
squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21