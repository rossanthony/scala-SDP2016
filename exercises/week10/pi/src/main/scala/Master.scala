import akka.actor.{Actor, ActorRef, Props}
import akka.routing.{ ActorRefRoutee, RoundRobinRoutingLogic, Router }

import scala.concurrent.duration._


class Master(nrOfWorkers: Int, nrOfMessages: Int, nrOfElements: Int, listener: ActorRef)
  extends Actor {

  var pi: Double = _
  var nrOfResults: Int = _
  val start: Long = System.currentTimeMillis

//  val workerRouter = context.actorOf(
//    Props[Worker].withRouter(RoundRobinRouter(nrOfWorkers)), name = "workerRouter")

    var router = {
      val routees = Vector.fill(nrOfWorkers) {
        val r = context.actorOf(Props[Worker])
        context watch r
        ActorRefRoutee(r)
      }
      Router(RoundRobinRoutingLogic(), routees)
    }

  def receive = {
    case Calculate ⇒
      for (i ← 0 until nrOfMessages) router.route(Work(i * nrOfElements, nrOfElements), sender())

    case Result(value) ⇒
      pi += value
      nrOfResults += 1
      if (nrOfResults == nrOfMessages) {
        // Send the result to the listener
        sender().tell(PiApproximation(pi, duration = (System.currentTimeMillis - start) millis), context.parent)

        //listener ! PiApproximation(pi, duration = (System.currentTimeMillis - start) millis)
        // Stops this actor and all its supervised children
        context stop self
      }
  }

}