package code

import net.liftweb.common.{Empty, Logger}
import akka.actor.{ActorSystem, Actor}
import akka.actor
import akka.util.duration._
import akka.util.Duration
import net.liftweb.http.S

class Main extends Actor with Logger {

  case object Tick

  context.system.scheduler.schedule(Duration.Zero, 5 seconds, self, Tick)

  protected def receive = {
    case Tick => {
      debug(S.session)
      debug("..")
      S.session.foreach(_.sendCometActorMessage("MyCometActor", Empty, ".."))
    }
    case m: Any => warn("Unknown message")
  }
}

object Main {

  val system = ActorSystem("Main")
  val instance = system.actorOf(actor.Props[Main], "main")
}
