import atomic.AtomicTest._

/**
  Define a class SimpleTime that takes two arguments: an Int that
  represents hours, and an Int that represents minutes.
  Use named arguments to create a SimpleTime object.
*/

case class SimpleTime(hours: Int, minutes: Int)

// Satisfy the following tests:
val t = new SimpleTime(hours=5, minutes=30)
t.hours is 5
t.minutes is 30


/**
  Using the solution for SimpleTime above, default minutes
  to 0 so that you don’t have to specify them.
*/

case class SimpleTime2(hours: Int, minutes: Int = 0)

// Satisfy the following tests:
val t2 = new SimpleTime2(hours=10)
t2.hours is 10
t2.minutes is 0

