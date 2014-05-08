package com.blackboxsociety.app.controllers.login

import com.blackboxsociety.mvc._
import com.blackboxsociety.http._
import scalaz.concurrent._
import scalaz.concurrent.Task._
import com.blackboxsociety.app.services._
import com.blackboxsociety.app.views.Login
import com.blackboxsociety.http.routes._

case class Get(services: ServiceManifest) extends Controller {

  val route = HttpRoute(MethodRoute(HttpGet), PathRoute("/login"))

  def action(request: HttpRequest): Task[HttpResponse] = now {
    Ok(Login())
  }

}
