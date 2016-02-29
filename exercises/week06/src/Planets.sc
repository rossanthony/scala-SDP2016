import atomic.AtomicTest._

/**
  Create a class Planet that has, by default, a single moon.
  The Planet class should have a name (String) and description
  (String). Use named arguments to specify the name and
  description, and a default for the number of moons.
*/

class Planet(name:String, description:String, moons:Int = 1) {
  val hasMoon: Boolean = moons > 0
}

// Satisfy the following tests:
val p = new Planet(
  name = "Mercury",
  description = "small and hot planet",
  moons = 0
)

p.hasMoon is false