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

