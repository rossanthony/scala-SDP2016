import atomic.AtomicTest._

/**
  q.8 Create a class Planet that has, by default, a single moon.
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


/**
  q.9 Modify your solution for the previous exercise by changing
  the order of the arguments that you use to create the Planet.
*/

// Satisfy the following tests:
val earth = new Planet(
  moons = 1,
  name = "Earth",
  description = "a hospitable planet"
)
earth.hasMoon is true

/**
  Did you have to change any code?
  - No, the order is not important when classes are defined
    with named arguments
*/
