addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.1")

addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.1.2")

resolvers += Resolver.url(
  "bintray-sbt-plugin-releases",
  url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
    Resolver.ivyStylePatterns)

resolvers += "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"

addSbtPlugin("me.lessis" % "less-sbt" % "0.2.2")

addSbtPlugin("org.scala-sbt" % "sbt-closure" % "0.1.4")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")
