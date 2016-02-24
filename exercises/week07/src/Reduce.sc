import com.atomicscala.AtomicTest._

/*
Rewrite the following code:
*/
val v = Vector(1, 10, 100, 1000)
v.reduce((sum, n) => sum + n) is 1111

var sum : Int = 0
for (n <- v) sum += n
sum is 1111

