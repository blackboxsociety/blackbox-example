package com.blackboxsociety.app.views

import com.blackboxsociety.mvc._
import scala.xml.Elem
import com.blackboxsociety.http.{HttpStringResponseBody, HttpResponseBody}
import scala.language.implicitConversions

trait Layout extends HtmlView {

  def render: Elem =
    <html>
      <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Spreading and connecting information" />
        <link rel="stylesheet" type="text/css" href="/assets/css/main.css" />
        <script type="text/javascript" src="/assets/javascript/main.js"></script>
        <title>Black Box Society</title>
      </head>
      <body>
        <div class="top nav">
          <div class="brand pull-left">
            <a href="/">Black Box Society</a>
          </div>
          <div class="identity-box pull-right"></div>
        </div>
        {container}
      </body>
    </html>

  def container: Elem

  override def toString = s"<!DOCTYPE html>\n${render.toString()}"

}

object Layout {
  implicit def stringToResponse(layout: Layout): HttpResponseBody = {
    HttpStringResponseBody(layout)
  }

}

case class Home() extends Layout {

  def container: Elem = <h1 class="blue">Welcome to black box society!</h1>

}

case class Login() extends Layout {

  def container: Elem =
    <form method="POST" action="/login">
      <input type="text" name="username"/>
      <input type="password" name="password"/>
      <input type="submit" value="Submit"/>
    </form>

}