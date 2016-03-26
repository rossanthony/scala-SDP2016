import akka.actor._

class Listener extends Actor {
  def receive = {
    case PiApproximation(pi, duration) ⇒
      println("\n\tPi approximation: \t\t%s\n\tCalculation time: \t%s"
        .format(pi, duration))
      context.system.shutdown()
  }
}