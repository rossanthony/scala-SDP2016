
// a)

List(List("a"), List("ab"), List("abc"), List("abcd")).map(
  x => x.count(s => s.length > 1))


List(List("a"), List("ab"), List("abc", "asdasdasd"), List("abcd")).map(
  x => x.count(s => s.length > 5))


// b)

List(List(11), List(12, 12), List(12, 4, 33), List(2, 3, 3, 12)).
  filter(x => x.length > 1).
    map(x => x.reduceRight((a,b) => a * b))

// reduceRight on List(12, 4, 33)
// will multiply all values in the list, i.e 12*4*33