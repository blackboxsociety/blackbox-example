package com.blackboxsociety.app

import com.blackboxsociety._
import com.blackboxsociety.app.services._
import com.blackboxsociety.app.middleware.global._
import com.blackboxsociety.mvc.middleware.global._
import com.blackboxsociety.mvc.middleware.general.EtagCacheMiddleware

object Main extends BlackBox {

  private val services = System.getenv("BB_ENV") match {
    case "dev" => DevServices
    case _     => DevServices
  }

  override def middleware = List(
    RequestLoggerMiddleware(),
    StaticFileMiddleware("/assets/", "target/resource_managed/main/public/"),
    EtagCacheMiddleware()
  )

  override def port: Int = services.serverSettings.port

  override def host: String = services.serverSettings.host

  override def router = services.router

}
