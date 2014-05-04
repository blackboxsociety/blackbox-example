package com.blackboxsociety.app.services.environments.dev

import com.blackboxsociety.app.services.interfaces.ServerComponent

trait DevServerComponent extends ServerComponent {

  case class ServerSettings(host: String, port: Int) extends ServerSettingsLike

  val serverSettings = ServerSettings("0.0.0.0", 3000)

}
