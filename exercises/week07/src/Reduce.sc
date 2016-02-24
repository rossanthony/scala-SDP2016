import com.atomicscala.AtomicTest._

/*
Rewrite the following code:
*/
val v = Vector(1, 10, 100, 1000)
v.reduce((sum, n) => sum + n) is 1111

var sum : Int = 0
for (n <- v) sum += n
sum is 1111


/*
Use reduce to implement a method sumIt that takes
a variable argument list and sums those arguments.
*/

def sumIt(args:Int*): Int = {
  args.reduce((sum, n) => sum + n)
}

// Satisfy the following tests:
sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195

