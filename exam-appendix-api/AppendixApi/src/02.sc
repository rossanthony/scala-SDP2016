
// What are the values of the following expressions?

List(List("a"), List("ab"), List("abc"), List("abcd")).map(x => x.count(s => s.length > 1))

// List[Int] = List(0, 1, 1, 1)


List(List(1), List(1, 1), List(1, 2, 3), List(3, 3, 12, 1)).filter(x => x.length > 1).map(x => x.reduceRight((a,b) => a * b))

// List[Int] = List(1, 1, 1)
