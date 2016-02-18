import com.atomicscala.AtomicTest._

// Modify the following code:

val v = Vector(1, 2, 3, 4)
v.map(n => n + 1) is Vector(2, 3, 4, 5)


// 1. a) so the anonymous function multiplies each value by 11 and adds 10.
// Satisfy the following tests:
val a = Vector(1, 2, 3, 4)
a.map(n => n * 11 + 10) is Vector(21, 32, 43, 54)


// b) Can you replace map with foreach in the above solution?
// What happens? Test the result.

val b = Vector(1, 2, 3, 4)
b.foreach(n => n * 11 + 10) is Vector(21, 32, 43, 54)

// [Error] expected: Vector(21, 32, 43, 54) res2: Unit = ()
// Not possible with foreach, no way to yield output as an immutable vector


// c) Rewrite the solution for the previous exercise part using for.
// Was this more or less complex than using map? Which approach has
// the greater potential for errors?

var c = Vector(1, 2, 3, 4)
(for (n <- c) yield n * 11 + 10) is Vector(21, 32, 43, 54)

// More straightforward to see what's going on with map,
// the 'for' version is slightly more verbose and as such
// more prone to errors