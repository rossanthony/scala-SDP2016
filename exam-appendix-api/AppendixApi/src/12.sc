
// %	Modulus Operator
// e.g. 12 % 4 = 0
//      12 % 5 = 2 (remainder of 2 after integer division)



def f(a: Int, b: Int): Int = {
  if (b == 0) a else f(b, a % b)
}

f(29, 5)

29 % 5
30 % 4  // = 2
4 % 2   // = 0

/* Trace:

  f(4, 30 % 4)  == f(4, 2)
  f(2, 4 % 2)   == f(2, 0)  returns a = 2

*/
