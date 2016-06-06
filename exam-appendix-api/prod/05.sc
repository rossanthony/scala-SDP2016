// Scala's for expression can be translated into applications of the
// higher-order functions map and filter. Consider the following for
// expression:

for(x <- 1 until 10; y = x * x; if y % 2 == 0) yield y + 3
// scala.collection.immutable.IndexedSeq[Int] = Vector(7, 19, 39, 67)


// Which of the following expressions is not equivalent to this expression?
// 2

// 1.
((1 until 10) map (x => x * x) filter (y => y % 2 == 0)) map (y => y + 3)
// scala.collection.immutable.IndexedSeq[Int] = Vector(7, 19, 39, 67)

// 2.
(1 until 10) map (x => x * x + 3) filter (y => y % 2 == 0)
// scala.collection.immutable.IndexedSeq[Int] = Vector(4, 12, 28, 52, 84)

// 3.
((1 until 10) filter ( y => y % 2 == 0)) map ( x => x * x) map( y => y + 3)
// scala.collection.immutable.IndexedSeq[Int] = Vector(7, 19, 39, 67)

// 4.
((1 until 10) filter (y => y % 2 == 0)) map (x => x * x + 3)
// scala.collection.immutable.IndexedSeq[Int] = Vector(7, 19, 39, 67)