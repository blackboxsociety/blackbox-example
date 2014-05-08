package com.blackboxsociety.app.controllers.index

import com.blackboxsociety.mvc._
import com.blackboxsociety.http._
import scalaz.concurrent._
import scalaz.concurrent.Task._
import com.blackboxsociety.app.services._
import com.blackboxsociety.app.views.Home
import com.blackboxsociety.http.routes._

case class Get(services: ServiceManifest) extends Controller {

  val route = HttpRoute(MethodRoute(HttpGet), PathRoute("/"))

  def action(request: HttpRequest): Task[HttpResponse] = now {
    val session = request.session(services.sessionSecret).set("key", "value")
    val flash   = request.flash(services.flashSecret).set("flash", "session")
    Ok(Home()).withSession(session).withFlash(flash)
  }

}
