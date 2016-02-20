// val l = (1,2,3) // Tuple
val l2 = (1,"String") // Tuple with mixed types

val s = Seq(1, 2, 3, 4) // Sequence with mixed types


//def square(x: Int): Int = x * x
// ^ equivalent to:
def square = (x: Int) => x * x
s.map(square)

// UAP - universal/uniform access principle
// see: http://joelabrahamsson.com/learning-scala-part-nine-uniform-access/

s.map((x: Int) => x * x)
s.map(x => x * x)
//    ^^^^^^^^^^ = lambda function mapped to 's'


/**
  * f: f[](val x: Int) => Option[Int]
  */
def f(x: Int): Option[Int] =
  if (x > 2) Some(x) else None


s.map(x => f(x))


val l = List(1, 2, 3, 4)
val m = List(6, 7, 9, 13)

l zip m
// res4: List[(Int, Int)] = List((1,6), (2,7), (3,9), (4,13))

def g(v: Int) = List(v-1, v, v+1)

g(3)
// res5: List[Int] = List(2, 3, 4)

l.map(x => g(x))
// res6: List[List[Int]] = List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4), List(3, 4, 5))

l.flatMap(x => g(x))
// res7: List[Int] = List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5)

l.map(x => f(x))
// res8: List[Option[Int]] = List(None, None, Some(3), Some(4))

l.flatMap(x => f(x))