package com.blackboxsociety.app.services.interfaces

trait ServerComponent {

  type ServerSettings <: ServerSettingsLike

  trait ServerSettingsLike {
    val host: String
    val port: Int
  }

  val serverSettings: ServerSettings

}
