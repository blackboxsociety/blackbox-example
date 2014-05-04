package com.blackboxsociety.app.services

import com.blackboxsociety.app.services.interfaces._
import com.blackboxsociety.app.services.common._
import com.blackboxsociety.app.services.environments.dev._


trait   ServiceManifest
extends RoutesComponent
with    SessionComponent
with    ServerComponent

object ServiceManifest {

  def apply(): ServiceManifest =

}

object  DevServices
extends ServiceManifest
with    CommonRoutesComponent
with    CommonSessionComponent
with    DevServerComponent