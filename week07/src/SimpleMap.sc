import com.atomicscala.AtomicTest._

// Modify the following code:

/*
val v = Vector(1, 2, 3, 4)
v.map(n => n + 1) is Vector(2, 3, 4, 5)
*/

// so the anonymous function multiplies each value by 11 and adds 10.
// Satisfy the following tests:
val v = Vector(1, 2, 3, 4)
v.map(n => n * 11 + 10) is Vector(21, 32, 43, 54)