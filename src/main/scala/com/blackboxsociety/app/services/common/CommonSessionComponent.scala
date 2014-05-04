package com.blackboxsociety.app.services.common

import com.blackboxsociety.app.services.interfaces._
import com.blackboxsociety.http.{FlashSecret, SessionSecret}

trait CommonSessionComponent extends SessionComponent {

  val sessionSecret = SessionSecret("Why is a raven like a writing desk?")

  val flashSecret = FlashSecret("We can plant a house, we can build a tree, i don't even care, we can do all three!")

}