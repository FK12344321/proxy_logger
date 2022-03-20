import akka.Done
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import java.io._

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import scala.io.StdIn

object MyHttpServer extends App {
  implicit val actorSystem = ActorSystem(Behaviors.empty, "akka-http")

  val route =
    path("") {
      get {
        val writer = new BufferedWriter(new FileWriter(new File("log.txt"), true))
        writer.write("Request\n")
        print("OK\n")
        writer.close()
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "Hello to all my clients!!!"))
      }
    }

  val bindFuture = Http().newServerAt("0.0.0.0", 8080).bind(route)

  while(true) {}
}
