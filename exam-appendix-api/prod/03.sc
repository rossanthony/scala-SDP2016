class Rational(n: Int, d: Int) {
  require(d != 0)
  val numer: Int = n
  val denom: Int = d
  override def toString = numer + "/" + denom
  def +(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
}

var fourth = new Rational(1, 4)
var third = new Rational(1, 3)
var x = fourth + third
x = x + x

// fourth: Rational = 1/4
// third: Rational = 1/3
// x: Rational = 7/12
// x: Rational = 168/144


// (a) How many Rational objects are created during the execution of this code? 2 marks
//     3
//     vars: fourth, third and x

// (b) What is the value of the variable x after the execution of the code fragment? 3 marks
//     x: Rational = 168/144

