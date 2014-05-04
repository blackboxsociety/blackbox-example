package com.blackboxsociety.app.services.interfaces

import com.blackboxsociety.http._

trait SessionComponent {

  val sessionSecret: SessionSecret

  val flashSecret: FlashSecret

}
