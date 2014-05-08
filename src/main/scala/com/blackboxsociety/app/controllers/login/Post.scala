package com.blackboxsociety.app.controllers.login

import com.blackboxsociety.mvc._
import com.blackboxsociety.http._
import scalaz.concurrent._
import com.blackboxsociety.app.services._
import com.blackboxsociety.mvc.form._
import com.blackboxsociety.http.routes._

case class Post(services: ServiceManifest) extends Controller {

  val route = HttpRoute(MethodRoute(HttpPost), PathRoute("/login"))

  val usernameC = FormConstraint().restrict(s => s.length > 3, "too short").restrict(s => s == "master", "you are not master")
  val passwordC = FormConstraint().restrict(s => !s.contains("123"), "contains 123")

  def action(request: HttpRequest): Task[HttpResponse] = {
    val f = Form.form("username" -> usernameC, "password" -> passwordC).fromBody(request)
    f.map(t =>
      t.validate(
        success => Ok("win bro"),
        errors => Ok("no win" + t.errors().toString)
      )
    )
  }

}
